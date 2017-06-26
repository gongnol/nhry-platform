package com.nhry.service.bill.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.dao.TMdMaraExMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.basic.domain.TMdMaraEx;
import com.nhry.data.bill.dao.EmpBillMapper;
import com.nhry.data.bill.dao.TMdDispRateItemMapper;
import com.nhry.data.bill.dao.TMdDispRateMapper;
import com.nhry.data.bill.dao.TMdEmpSalMapper;
import com.nhry.data.bill.domain.TMdDispRate;
import com.nhry.data.bill.domain.TMdDispRateItem;
import com.nhry.data.bill.domain.TMdEmpSal;
import com.nhry.model.bill.*;
import com.nhry.model.bill.EmpSalQueryModel;
import com.nhry.service.bill.dao.EmpBillService;
import com.nhry.utils.PrimaryKeyUtils;
import com.nhry.utils.SysContant;
import com.nhry.utils.YearLastMonthUtil;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by gongjk on 2016/7/1.
 */
public class EmpBillServiceImpl implements EmpBillService {
    private EmpBillMapper empBillMapper;
    private TMdDispRateMapper tMdDispRateMapper;
    private TMdDispRateItemMapper tMdDispRateItemMapper;
    private TMdBranchEmpMapper branchEmpMapper;
    private UserSessionService userSessionService;
    private TMdEmpSalMapper tMdEmpSalMapper;
    private TSysUserRoleMapper urMapper;
    private TMdMaraExMapper tMdMaraExMapper;
    private TMdBranchMapper branchMapper;


    public void setBranchMapper(TMdBranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    public void setUrMapper(TSysUserRoleMapper urMapper) {
        this.urMapper = urMapper;
    }

    public void settMdEmpSalMapper(TMdEmpSalMapper tMdEmpSalMapper) {
        this.tMdEmpSalMapper = tMdEmpSalMapper;
    }
    public void settMdMaraExMapper(TMdMaraExMapper tMdMaraExMapper) {
        this.tMdMaraExMapper = tMdMaraExMapper;
    }
    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }
    public void setBranchEmpMapper(TMdBranchEmpMapper branchEmpMapper) {
        this.branchEmpMapper = branchEmpMapper;
    }
    public void setEmpBillMapper(EmpBillMapper empBillMapper) {
        this.empBillMapper = empBillMapper;
    }
    public void settMdDispRateMapper(TMdDispRateMapper tMdDispRateMapper) {
        this.tMdDispRateMapper = tMdDispRateMapper;
    }

    public void settMdDispRateItemMapper(TMdDispRateItemMapper tMdDispRateItemMapper) {
        this.tMdDispRateItemMapper = tMdDispRateItemMapper;
    }

    @Override
    public PageInfo empDispDetialInfo(EmpDispDetialInfoSearch eSearch) {
        if(StringUtils.isBlank(eSearch.getPageNum()) || StringUtils.isBlank(eSearch.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        eSearch.setBranchNo(user.getBranchNo());
        eSearch.setDealerNo(user.getDealerId());
        eSearch.setSalesOrg(user.getSalesOrg());
        return  empBillMapper.empDispDetialInfo(eSearch);
    }

    @Override
    public PageInfo empAccountReceAmount(EmpDispDetialInfoSearch eSearch) {
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isBlank(eSearch.getPageNum()) || StringUtils.isBlank(eSearch.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        eSearch.setBranchNo(user.getBranchNo());
        eSearch.setDealerNo(user.getDealerId());
        eSearch.setSalesOrg(user.getSalesOrg());
        return  empBillMapper.empAccountReceAmount(eSearch);
    }

    /**
     * 根据  数量  获取按 数量结算  的配送费率
     * @param empNo
     * @param dispNum  配送数量
     * @return  配送数量所在范围的配送费率
     */
    @Override
    public BigDecimal CalculateEmpTransRateByNum(String empNo,int dispNum) {
        String message = "";
        TMdBranchEmp emp =branchEmpMapper.selectBranchEmpByNo(empNo);
        if(emp == null){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"该员工不存在！");
        }
        String salaryMet = emp.getSalaryMet();
        String salesOrg = emp.getSalesOrg();
        BigDecimal result = new BigDecimal(0);
        int j = 0;
        List<TMdDispRateItem> oldList = tMdDispRateItemMapper.getDispRateNumBySalOrg(salesOrg);
        //如果是数量
        if(StringUtils.isBlank(salaryMet)){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"员工  " +emp.getEmpName() +"  没有维护工资结算方式 信息，请先在员工信息中维护");
        }
        if("10".equals(salaryMet)){
            if(oldList!=null && oldList.size() >0){
              for(int i=0;i<oldList.size();i++){
                  TMdDispRateItem item = oldList.get(i);
                 int  endNum =item.getItemValue();
                  if(dispNum < endNum ){
                    break;
                  }else{
                      j = i;
                  }
              }
            }
            return oldList.get(j).getRate();
        }

        throw new ServiceException(MessageCode.LOGIC_ERROR,"配送数 不在输入的阶梯范围内!!! 请审查");
    }

    /**
     * 获取按  产品 结算的运送费率
     * @param matnr 产品编码
     * @param salesOrg  销售组织
     * @return  产品的配送费
     */

    public BigDecimal CalculateEmpTransRateByProduct(String matnr,String salesOrg){
        TMdMaraEx product = tMdMaraExMapper.getProductTransRateByCode(matnr,salesOrg);
        if(product == null || product.getRate() == null){
           return new BigDecimal(0);
        }
        return product.getRate();
    }

    /**
     * 修改配送费率
     * @param sModel
     *
     * @return
     */
    @Override
    public int uptEmpDispRate(SaleOrgDispRateModel sModel) {
       try{
           TMdDispRate dispRate =  null;
//           String salesOrg = sModel.getSalesOrg();
           TSysUser user =  userSessionService.getCurrentUser();
           String salesOrg = user.getSalesOrg();
           dispRate = tMdDispRateMapper.getDispRateBySaleOrg(salesOrg);
           //原来的结算方式已有 则更新
           if(dispRate!=null){
               dispRate.setSalaryMet(sModel.getSalaryMet());
               dispRate.setLastModified(new Date());
               dispRate.setLastModifiedBy(user.getLoginName());
               dispRate.setLastModifiedByTxt(user.getDisplayName());
               tMdDispRateMapper.uptDispRateTypeBySaleOrg(dispRate);
           }else{
               dispRate = new  TMdDispRate();
               dispRate.setSalesOrg(salesOrg);
               dispRate.setSalaryMet(sModel.getSalaryMet());
               dispRate.setCreateBy(user.getLoginName());
               dispRate.setCreateByTxt(user.getDisplayName());
               dispRate.setLastModified(new Date());
               dispRate.setLastModifiedBy(user.getLoginName());
               dispRate.setLastModifiedByTxt(user.getDisplayName());
               tMdDispRateMapper.addDispRateSalOrg(dispRate);
           }

           //如果前台传来的是数量计算
           if("10".equals(sModel.getSalaryMet())){
               //然后判断原来的以数量结算方式是否存在
               List<TMdDispRateItem> oldList = tMdDispRateItemMapper.getDispRateNumBySalOrg(salesOrg);
               if(oldList != null){
                   //先删除
                   tMdDispRateItemMapper.delDispRateNumBySaleOrg(salesOrg);
               }
               //再添加新的以数量结算方式
               List<DispNumEntry> entries = sModel.getDispNumEntries();
               if(entries!=null && entries.size()>0){
                   for (int i =1;i<=entries.size() ;i++ ){
                       DispNumEntry entry = entries.get(i-1);
                       TMdDispRateItem item = new TMdDispRateItem();
                       item.setSalesOrg(salesOrg);
                       item.setItemNo(PrimaryKeyUtils.generateUuidKey());
                       item.setItemIndex(i);
                       item.setRate(entry.getRate());
                       item.setItemValue(entry.getStartValue());
                       item.setCreateBy(user.getLoginName());
                       item.setCreateByTxt(user.getDisplayName());
                       item.setLastModified(new Date());
                       item.setLastModifiedBy(user.getLoginName());
                       item.setLastModifiedByTxt(user.getDisplayName());
                       tMdDispRateItemMapper.addDispRateItem(item);
                   }
               }
           }
           else{
               List<DispProductEntry> entries = sModel.getDispProductEntries();
               if(entries!=null && entries.size()>0){
                   for (DispProductEntry entry :entries ){
                       TMdMaraEx ex = new TMdMaraEx();
                       ex.setSalesOrg(salesOrg);
                       ex.setMatnr(entry.getMatnr());
                       ex.setRate(entry.getDispRate());
                       tMdMaraExMapper.uptProductExByCodeAndSalesOrg(ex);
                   }
               }
           }
           return 1;
      }catch (Exception e){
           throw new ServiceException(MessageCode.LOGIC_ERROR,"更新或创建失败！");
       }
    }

    /**
     * 获取当前登录人所在销售组织下的配送费率
     * @return
     */
    @Override
    public SaleOrgDispRateModel getSalesOrgDispRate() {
        SaleOrgDispRateModel model = new SaleOrgDispRateModel();
        TSysUser user = userSessionService.getCurrentUser();
        String salesOrg = user.getSalesOrg();
        if(StringUtils.isBlank(salesOrg)){
            throw  new ServiceException(MessageCode.LOGIC_ERROR,"当前登录人没分配销售组织，数据有问题！");
        }
        TMdDispRate rate = tMdDispRateMapper.getDispRateBySaleOrg(salesOrg);
        model.setSalesOrg(salesOrg);
        model.setSalaryMet(rate.getSalaryMet());
        model.setSalesOrgName(rate.getSalesOrgName());
        //如果是数量
        if("10".equals(rate.getSalaryMet())){
            List<TMdDispRateItem> items = tMdDispRateItemMapper.getDispRateNumBySalOrg(salesOrg);
            List<DispNumEntry> entries = new ArrayList<DispNumEntry>();
            if(items!=null && items.size()>0){

                TMdDispRateItem it = items.get(0);
                int startValue = it.getItemValue();
                BigDecimal result = it.getRate();

                for( int i=1;i<items.size();i++ ){
                    TMdDispRateItem item = items.get(i);
                    DispNumEntry entry  = new DispNumEntry();
                    entry.setStartValue(startValue);
                    entry.setEndValue(item.getItemValue()-1);
                    entry.setRate(result);
                    entries.add(entry);
                    result = item.getRate();
                    startValue = item.getItemValue();
                }
                DispNumEntry entry  = new DispNumEntry();
                entry.setStartValue(startValue);
                entry.setRate(result);
                entries.add(entry);
            }
            model.setDispNumEntries(entries);

        }else{
            List<TMdMaraEx> items = tMdMaraExMapper.getProductsBySalesOrg(salesOrg);
            List<DispProductEntry> entries = new ArrayList<DispProductEntry>();
            if(items!=null && items.size()>0){
                for(TMdMaraEx item: items){
                    DispProductEntry entry = new DispProductEntry();
                    entry.setDispRate(item.getRate());
                    entry.setMatnr(item.getMatnr());
                    entries.add(entry);
                }
            }
            model.setDispProductEntries(entries);
        }

        return model;
    }

    @Override
    public PageInfo searchEmpSalaryRep(EmpDispDetialInfoSearch eSearch) {
        TSysUser user = userSessionService.getCurrentUser();
        eSearch.setSalesOrg(user.getSalesOrg());
        if(StringUtils.isBlank(eSearch.getPageNum()) || StringUtils.isBlank(eSearch.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        String yearMonth = YearLastMonthUtil.getYearMonth(eSearch.getSalDate());
        eSearch.setYearMonth(yearMonth);
        eSearch.setBranchNo(user.getBranchNo());
        eSearch.setDealerNo(user.getDealerId());
        eSearch.setSalesOrg(user.getSalesOrg());

        PageInfo result = tMdEmpSalMapper.searchEmpSalaryRep(eSearch);
        return result;
    }

    /**
     * 结算上个月月工资（登录人所在奶站下的所有送奶工）
     * @return
     */
    @Override
    public PageInfo setBranchEmpSalary() {
        TSysUser user = userSessionService.getCurrentUser();
        String branchNo = user.getBranchNo();
        EmpDispDetialInfoSearch search = new EmpDispDetialInfoSearch();
        search.setBranchNo(branchNo);
        //获取上个月的第一天
        Date firstDay = YearLastMonthUtil.getLastMonthFirstDay();
        search.setStartDate(firstDay);
        //获取上个月的最后一天
        Date lastDay = YearLastMonthUtil.getLastMonthLastDay();
        search.setEndDate(YearLastMonthUtil.getLastMonthLastDay());
        //获取上个月  例如今天是2016-07-02  结果是201606
        String setYearMonth = YearLastMonthUtil.getYearLastMonth();


        List<String> coms = this.getCompanyCodeForDispFee();
        boolean flag = coms.contains(user.getBranchNo()) ? true : false;

        EmpSalQueryModel smodel = new EmpSalQueryModel();
        smodel.setBranchNo(user.getBranchNo());
        smodel.setSalesOrg(user.getSalesOrg());
        smodel.setStartDate(firstDay);
        smodel.setEndDate(lastDay);

        List<TMdBranchEmp> empList =  branchEmpMapper.getAllRationalMilkManByBranchNo(smodel);

        if(empList!=null && empList.size()>0){
            for(TMdBranchEmp emp : empList){
                search.setEmpNo(emp.getEmpNo());
                this.setEmpSalary(emp,search,setYearMonth,user,flag);
            }
        }
        EmpDispDetialInfoSearch esearch = new EmpDispDetialInfoSearch();
        esearch.setBranchNo(user.getBranchNo());
        esearch.setSalesOrg(user.getSalesOrg());
        esearch.setSalDate(YearLastMonthUtil.getLastMonthFirstDay());
        esearch.setPageNum("1");
        esearch.setPageSize("10");
        return this.searchEmpSalaryRep(esearch);
    }

    /**
     * 根据员工工资单流水号获取 员工本月工资详情
     * @param empSalLsh
     * @return
     */
    @Override
    public TMdEmpSal getEmpSalaryBySalaryNo(String empSalLsh) {
        return tMdEmpSalMapper.getEmpSalByEmpSalLsh(empSalLsh);
    }


    /**
     * 结算本月工资（登录人所在奶站下的所有送奶工）
     * @return
     */
    @Override
    public PageInfo setBranchEmpSalaryThisMonth() {
        TSysUser user = userSessionService.getCurrentUser();
        TMdBranch branch = branchMapper.selectBranchByNo(user.getBranchNo());
        EmpDispDetialInfoSearch search = new EmpDispDetialInfoSearch();
        search.setBranchNo(user.getBranchNo());
        //获取这个月的第一天
        Date firstDay = YearLastMonthUtil.getThisMonthFirstDay();
        search.setStartDate(firstDay);
        //获取这个月的最后一天
        Date lastDay = YearLastMonthUtil.getThisMonthLastDay();
        search.setEndDate(lastDay);
        //获取上个月  例如今天是2016-07-02  结果是201606
        String setYearMonth = YearLastMonthUtil.getYearThisMonth();
        List<String> coms = this.getCompanyCodeForDispFee();
        boolean flag = coms.contains(branch.getCompanyCode()) ? true : false;
        EmpSalQueryModel smodel = new EmpSalQueryModel();
        smodel.setBranchNo(user.getBranchNo());
        smodel.setSalesOrg(user.getSalesOrg());
        smodel.setStartDate(firstDay);
        smodel.setEndDate(lastDay);
        List<TMdBranchEmp> empList =  branchEmpMapper.getAllRationalMilkManByBranchNo(smodel);
        if(empList!=null && empList.size()>0){
            for(TMdBranchEmp emp : empList){
                search.setEmpNo(emp.getEmpNo());
                this.setEmpSalary(emp,search,setYearMonth,user,flag);
            }
        }

        EmpDispDetialInfoSearch esearch = new EmpDispDetialInfoSearch();
        esearch.setBranchNo(user.getBranchNo());
        esearch.setSalesOrg(user.getSalesOrg());
        esearch.setSalDate(new Date());
        esearch.setPageNum("1");
        esearch.setPageSize("10");
        return this.searchEmpSalaryRep(esearch);
    }

    /**
     * 结算送奶员本月工资,基本工资 + 产品配送费 + 赠品配送费+ 内部销售订单配送费
     * @param emp 员工信息、search 日期范围，setYearMonth 日期范围对应的年月 、user 操作人信息，flag==true?计算配送费:不计算配送费
     *   1、获取该员工的工资单  如果有则删除重生
     *   2、按数量结算或者按产品结算
     *        ⑴计算产品配送费（如果按数量结算：统计路单中正品配送数量*记录的销售组织下阶梯配送费率 ，如果按产品结算：计算产品扩展表中记录的产品配送费率*数量  之和）
     *        ⑵计算产品内部销售订单费（如果按数量结算：内部销售订单数量*记录的销售组织下阶梯配送费率，如果按产品结算：计算产品扩展表中记录的产品配送费率*数量  之和）
     *        ⑶计算产品赠品配送费(如果按数量结算：统计路单中赠品配送数量*记录的销售组织下阶梯配送费率，如果按产品结算：计算产品扩展表中记录的产品配送费率*数量  之和）
     *  *注：如果是按数量结算查配送费率，将三种产品配送数量相加  匹配  记录的销售组织下阶梯配送费率 ，找到符合的范围，查出配送费率
     *   3、最后将计算出来的工资记录到员工工资表中
     * @return
     */
    public int setEmpSalary(TMdBranchEmp emp,EmpDispDetialInfoSearch search,String setYearMonth,TSysUser user,boolean flag){
        String empNo = emp.getEmpNo();
        Map<String,String> map =new HashMap<String,String>();
        map.put("empNo",empNo);
        map.put("setYearMonth",setYearMonth);

        TMdEmpSal empSal = tMdEmpSalMapper.getEmpSalByEmpNoAndDate(map);
        if(empSal!=null){
            tMdEmpSalMapper.delEmpSalByEmpNoAndDate(map);
        }
        empSal = tMdEmpSalMapper.getEmpSalByEmpNoAndDate(map);
        if(empSal == null){
            empSal = new TMdEmpSal();
            empSal.setEmpSalLsh(PrimaryKeyUtils.generateUuidKey());
            empSal.setEmpNo(empNo);
            //三种配送费
            //如果 计算配送费
            if(flag){
                //如果配送费按产品结算
                if("20".equals(emp.getSalaryMet())){
                    //产品数量
                    int dispAllNum =0;
                    //按产品结算  //产品配送费
                    List<EmpAccoDispFeeByProduct> pro = empBillMapper.empDisByProduct(search);
                    BigDecimal dispFee = this.getEmpDispFee(pro,emp.getSalesOrg());
                    dispAllNum = dispAllNum +( pro !=null || pro.size()>0 ? pro.size() : 0);
                    empSal.setDispSal(dispFee);

                    //按产品结算  //内部销售配送费
                    List<EmpAccoDispFeeByProduct> proIn = empBillMapper.empInDispByProduct(search);
                    dispAllNum = dispAllNum +( proIn !=null || proIn.size()>0 ? proIn.size() : 0);
                    BigDecimal inDispFee = this.getEmpDispFee(proIn,emp.getSalesOrg());
                    empSal.setInDispSal(inDispFee);

                    //按产品结算  //赠品配送费
                    List<EmpAccoDispFeeByProduct> proFree = empBillMapper.empFreeDispByProduct(search);
                    BigDecimal dispFreeFee = this.getEmpDispFee(proFree,emp.getSalesOrg());
                    dispAllNum = dispAllNum +( proFree !=null || proFree.size()>0 ? proFree.size() : 0);
                    empSal.setSendDispSal(dispFreeFee);
                    empSal.setDispNum(dispAllNum);
                }
                else{
                    //配送费按数量结算
                    int dispNum = empBillMapper.empDispFeeNum(search);
                    int inDispNum = empBillMapper.empInDispFeeNum(search);
                    int sendDispNum = empBillMapper.empFreeDispFeeNum(search);
                    int totaNum = dispNum + inDispNum + sendDispNum;

                    BigDecimal rate =  this.CalculateEmpTransRateByNum(empNo,totaNum);
                    //按数量结算  //产品配送费
                    empSal.setDispSal(rate.multiply(new BigDecimal(dispNum)));
                    //按数量结算  //内部销售配送费
                    empSal.setInDispSal(rate.multiply(new BigDecimal(inDispNum)));
                    //按数量结算  //赠品配送费
                    empSal.setSendDispSal(rate.multiply(new BigDecimal(sendDispNum)));

                    empSal.setDispNum(totaNum);
                }
                empSal.setTotalSal(empSal.getInDispSal().add(empSal.getDispSal()).add(empSal.getSendDispSal()).add(new BigDecimal(emp.getBaseSalary())));
            }else{
                //不计算配送费
                empSal.setInDispSal(BigDecimal.ZERO);
                empSal.setDispSal(BigDecimal.ZERO);
                empSal.setSendDispSal(BigDecimal.ZERO);
                empSal.setTotalSal(new BigDecimal(emp.getBaseSalary()));
            }



            empSal.setCreateAt(new Date());
            empSal.setSetDate(new Date());
            empSal.setSetYearMonth(setYearMonth);
            empSal.setCreateBy(user.getLoginName());
            empSal.setCreateByTxt(user.getDisplayName());
            tMdEmpSalMapper.addEmpSal(empSal);

        }
        return 1;
    }

    //计算配送费（按产品结算）
    public BigDecimal getEmpDispFee( List<EmpAccoDispFeeByProduct> detail,String salesOrg){
             BigDecimal result = new BigDecimal(0);
            if(detail!=null && detail.size()>0){
                for(EmpAccoDispFeeByProduct pro: detail){
                    BigDecimal dispRate = this.CalculateEmpTransRateByProduct(pro.getMatnr(),salesOrg);
                    BigDecimal dispFee = dispRate.multiply(new BigDecimal(pro.getQty()));
                    result =  result.add(dispFee);
                }
            }
             return result;
     }

    public  List<String> getCompanyCodeForDispFee(){
        List<String> result = new ArrayList<String>();
        String str = SysContant.getSystemConst("COMPANT_DISP_FEE");
        if(StringUtils.isNoneBlank(str)){
            result = Arrays.asList(str.split(","));
        }
        return result;
    }

}
