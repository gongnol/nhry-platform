package com.nhry.service.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.milktrans.domain.TSsmSalOrder;
import com.nhry.model.basic.BranchEmpSearchModel;
import com.nhry.model.basic.BranchSalesOrgModel;
import com.nhry.model.basic.EmpQueryModel;
import com.nhry.service.BaseService;
import com.nhry.service.basic.dao.BranchEmpService;
import com.nhry.service.basic.dao.TSysMessageService;
import com.nhry.service.basic.pojo.BranchEmpModel;
import com.nhry.utils.PrimaryKeyUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.task.TaskExecutor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BranchEmpServiceImpl extends BaseService implements BranchEmpService {
	
	private TMdBranchEmpMapper branchEmpMapper;
	private TMdBranchMapper tMdBranchMapper;
	private UserSessionService userSessionService;
	private TSysUserRoleMapper userRoleMapper;
	private TSysMessageService messageService;
	private TaskExecutor taskExecutor;



	@Override
	public int deleteBranchEmpByNo(String empNo) {
		// TODO Auto-generated method stub
		TMdBranchEmp emp = this.selectBranchEmpByNo(empNo);
		if(emp == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该员工编号对应的员工信息不存在!");
		}
		TMdBranchEmp record = new TMdBranchEmp();
		record.setStatus("0");
		record.setEmpNo(empNo);
		record.setLastModified(new Date());
		/*record.setLastModifiedBy(userSessionService.getCurrentUser().getLoginName());
		record.setLastModifiedByTxt(userSessionService.getCurrentUser().getDisplayName());*/

		return branchEmpMapper.deleteBranchEmp(record);
	}

	@Override
	public int addBranchEmp(TMdBranchEmp record,boolean isLeave) {
		TSysUser sysuser = userSessionService.getCurrentUser();
        this.taskExecutor.execute(new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				this.setName("sendMessageForEmpUpt");
				TMdBranchEmp emp = branchEmpMapper.selectActiveBranchEmpByNo(record.getEmpNo());
				if(emp != null){
					if(!emp.getBranchNo().equals(record.getBranchNo())){
						//再处理原奶站员工离职问题
						emp.setEmpNo(record.getEmpNo());
						emp.setLeaveDate(new Date());
						emp.setStatus("0");
						emp.setLastModified(new Date());
						emp.setLastModifiedBy(sysuser.getLoginName());
						emp.setLastModifiedByTxt(sysuser.getDisplayName());
					    branchEmpMapper.uptBranchEmpByBraNo(emp);
						messageService.sendMessageForEmpUpt(emp, "upt", sysuser);
						
						//员工奶站变更(原账号  变成离职，在新奶站建立一个新员工数据)
						//先处理在新奶站建立一个新员工数据
						if(!isLeave){
							//建立新员工
							try {
								TMdBranchEmp newEmp = (TMdBranchEmp)emp.clone();
								newEmp.setSalesOrg(record.getSalesOrg());
								newEmp.setBranchNo(record.getBranchNo());
								newEmp.setEmpNo(PrimaryKeyUtils.generateUuidKey());
								newEmp.setMp(!StringUtils.isEmpty(record.getMp()) ? record.getMp() : emp.getMp());
								newEmp.setEmpName(record.getEmpName());
								newEmp.setLastModified(new Date());
								newEmp.setLastModifiedBy(sysuser.getLoginName());
								newEmp.setLastModifiedByTxt(sysuser.getDisplayName());
								newEmp.setStatus("1");
								newEmp.setLeaveDate(null);
								//往调整后的奶站的copy一个员工
								branchEmpMapper.addBranchEmp(newEmp);
								messageService.sendMessageForEmpUpt(newEmp, "add", sysuser);
							} catch (CloneNotSupportedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}else{
					record.setCreateAt(new Date());
					record.setCreateBy(sysuser.getLoginName());
					record.setCreateByTxt(sysuser.getDisplayName());
					record.setStatus("1");
				   branchEmpMapper.addBranchEmp(record);
				   messageService.sendMessageForEmpUpt(emp, "add", sysuser);
				}
			}
        });
		return 1;
	}

	@Override
	public TMdBranchEmp selectBranchEmpByNo(String empNo) {
		// TODO Auto-generated method stub
		return branchEmpMapper.selectBranchEmpByNo(empNo);
	}


	@Override
	public BranchEmpModel empDetailInfo(String empNo) {
		return branchEmpMapper.empDetailInfo(empNo);
	}

	@Override
	public List<TMdBranch> getComPanyAllBranch() {
		TSysUser user = userSessionService.getCurrentUser();
		String salesOrg = user.getSalesOrg();
		String branchNo = user.getBranchNo();
		if(StringUtils.isBlank(salesOrg)){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "登录用户所在销售组织不存在!");
		}
		if(StringUtils.isNoneBlank(branchNo)){
			List<TMdBranch> branchlist = new ArrayList<TMdBranch>();
			TMdBranch branch = tMdBranchMapper.selectBranchByNo(branchNo);
			branchlist.add(branch);
			return branchlist ;
		}else{
			BranchSalesOrgModel bModel = new BranchSalesOrgModel();
			bModel.setSalesOrg(salesOrg);
			return tMdBranchMapper.findBranchListByOrg(bModel);
		}

	}

	@Override
	public List<TMdBranchEmp> getAllEmpByBranchNo(String branchNo) {
		if(StringUtils.isBlank(branchNo)){
			branchNo = userSessionService.getCurrentUser().getBranchNo();
		}
		String salesOrg = userSessionService.getCurrentUser().getSalesOrg();
		return branchEmpMapper.getAllEmpMilkManByBranchNo(branchNo,salesOrg);
	}

	@Override
	public List<TMdBranchEmp> getAllEmpBySalesOrg() {
		TSysUser user = userSessionService.getCurrentUser();

		return branchEmpMapper.getAllEmpBySalesOrg(user.getSalesOrg());
	}

	@Override
	public List<TMdBranchEmp> getAllBranchEmpByNo(BranchEmpSearchModel bModel) {
		TSysUser user = userSessionService.getCurrentUser();
		bModel.setSalesOrg(user.getSalesOrg());
		if(StringUtils.isBlank(bModel.getBranchNo())){
			bModel.setBranchNo(user.getBranchNo());
		}
		bModel.setDealerNo(user.getDealerId());

		return branchEmpMapper.getAllBranchEmpByNo(bModel);
	}

	@Override
	public int uptBranchEmpByNo(TMdBranchEmp record) {
		// TODO Auto-generated method stub
		TMdBranchEmp emp = this.selectBranchEmpByNo(record.getEmpNo());
		if(emp == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该员工编号对应的员工信息不存在!");
		}
		if(StringUtils.isNotEmpty(record.getSapcode())){
			int i = branchEmpMapper.isEmp(record);
			if(i > 0){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "该SAP客户编码已经存在!");
			}
			if(StringUtils.isNotEmpty(emp.getSapcode())){
				//更新销售订单送奶工对应的sapCode
				List<TSsmSalOrder> ssmSalOrders = branchEmpMapper.selectSalOrderByOnlineCode(emp.getSapcode());
				if(ssmSalOrders.size() > 0 ){
					ssmSalOrders.forEach( e -> {
						e.setOnlineCode(record.getSapcode());
						branchEmpMapper.updateSapCode(e);
					});
				}
			}
		}
		record.setLastModified(new Date());
		record.setLastModifiedBy(userSessionService.getCurrentUser().getLoginName());
		record.setLastModifiedByTxt(userSessionService.getCurrentUser().getDisplayName());
		return branchEmpMapper.uptBranchEmpByNo(record);
	}

	public void setBranchEmpMapper(TMdBranchEmpMapper branchEmpMapper) {
		this.branchEmpMapper = branchEmpMapper;
	}

	public void settMdBranchMapper(TMdBranchMapper tMdBranchMapper) {
		this.tMdBranchMapper = tMdBranchMapper;
	}

	public void setUserRoleMapper(TSysUserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}

	@Override
	public void setUserSessionService(UserSessionService userSessionService) {
		this.userSessionService = userSessionService;
	}

	@Override
	public PageInfo searchBranchEmp(EmpQueryModel smodel) {
		TSysUser user = userSessionService.getCurrentUser();
		if(smodel.getBranchNo() == null){
			smodel.setBranchNo(user.getBranchNo());
		}
		if(smodel.getSalesOrg() == null){
			smodel.setSalesOrg(user.getSalesOrg());
		}
		if(smodel.getDealerNo() == null){
			smodel.setDealerNo(user.getDealerId());
		}
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
		}
		return branchEmpMapper.searchBranchEmp(smodel);
	}

	@Override
	public List<TMdBranchEmp> queryBranchEmp(EmpQueryModel smodel){
		TSysUser user = userSessionService.getCurrentUser();
		if(smodel.getBranchNo() == null){
			smodel.setBranchNo(user.getBranchNo());
		}
		if(smodel.getSalesOrg() == null){
			smodel.setSalesOrg(user.getSalesOrg());
		}
		if(smodel.getDealerNo() == null){
			smodel.setDealerNo(user.getDealerId());
		}
		return branchEmpMapper.queryBranchEmp(smodel);
	}

	public void setMessageService(TSysMessageService messageService) {
		this.messageService = messageService;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}


}
