package com.nhry.service.webService.impl;

import com.nhry.data.basic.dao.TMdDealerMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdDealer;
import com.nhry.model.webService.CustInfoModel;
import com.nhry.model.webService.DealerBranchModel;
import com.nhry.service.basic.dao.BranchService;
import com.nhry.service.external.EcBaseService;
import com.nhry.service.webService.dao.GetOrderBranchService;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gongjk on 2016/7/27.
 */
public class GetOrderBranchServiceImpl implements GetOrderBranchService {
    private EcBaseService ecBaseService;
    private BranchService branchService;
    private TMdDealerMapper dealerMapper;
    @Override
    public DealerBranchModel getOrderBranch(CustInfoModel custInfoModel) {

        JSONObject obj = this.dataToJson(custInfoModel);
        String strObje = "["+obj.toString()+"]";

        String url = "http://ec2-54-222-230-211.cn-north-1.compute.amazonaws.com.cn/FY_MOBILE_SVR/WFY_UNI_SERVICE.json?method=callProcService";
       //String url = "http://wfyerpqd.6655.la:30017/FY_MOBILE_XXW_SVR/WFY_UNI_SERVICE.json?method=callProcService";
        JSONObject resultJson =  ecBaseService.pushMessage2Ec(url,strObje,false);
        if(resultJson !=null){
            DealerBranchModel model = new DealerBranchModel();
            try {
               JSONArray result =  resultJson.getJSONObject("procExecResults").getJSONObject("SVCGETORDERBRANCH").getJSONObject("resultList").getJSONObject("AC_RESULT").getJSONArray("rows");
                if(result!=null && !result.isNull(0)){
                    String branchNo = result.getJSONObject(0).getString("branchno");
                    TMdBranch branch = branchService.selectBranchByNo(branchNo);
                    model.setBranch(branch);
                    if("01".equals(branch.getBranchGroup())){
                        TMdDealer dealer = new TMdDealer();
                        dealer.setDealerNo("-1");
                        dealer.setDealerName("自营奶站");
                        model.setDealer(dealer);
                    }else{
                        TMdDealer dealer = dealerMapper.selectDealerByNo(branch.getDealerNo());
                        model.setDealer(dealer);
                    }
                    return model;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public  JSONObject dataToJson(CustInfoModel custInfoModel){
        Map<String,String> data = new HashMap<String,String>();
        data.put( "customerId","CallCenter");
        data.put("vipGuid",custInfoModel.getVipGuid());
        data.put("province",custInfoModel.getProvince());
        data.put("city",custInfoModel.getCity());
        data.put("district",custInfoModel.getDistrict());
        data.put("street",custInfoModel.getStreet());
        data.put("townName",custInfoModel.getTownName());
        data.put("address",custInfoModel.getAddress());
        data.put("longitude",custInfoModel.getLongitude());
        data.put("latitude",custInfoModel.getLatitude());
        data.put("townId",custInfoModel.getTownId());
        JSONArray obj4 = new JSONArray();
        obj4.put(data);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("serviceName","SVCGETORDERBRANCH");
        map3.put("data",obj4);
        JSONObject obj3 = new JSONObject(map3);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("SVCGETORDERBRANCH",obj3);
        JSONObject obj2 = new JSONObject(map2);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("businessno","BUSSGETORDERBRANCH");
        map.put("body",obj2);


        JSONObject obj = new JSONObject(map);
        return obj;
    }

    public void setEcBaseService(EcBaseService ecBaseService) {
        this.ecBaseService = ecBaseService;
    }

    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }

    public void setDealerMapper(TMdDealerMapper dealerMapper) {
        this.dealerMapper = dealerMapper;
    }
}
