package com.nhry.service.basic.impl;

import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.dao.TMdBranchScopeMapper;
import com.nhry.data.basic.dao.TMdResidentialAreaMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchScopeKey;
import com.nhry.service.BaseService;
import com.nhry.service.basic.dao.TMdBranchScopeService;
import com.nhry.service.basic.dao.TSysMessageService;
import com.nhry.service.external.dao.EcService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.task.TaskExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gongjk on 2016/6/7.
 */
public class TMdBranchScopeServiceImpl extends BaseService implements TMdBranchScopeService {

    private TMdBranchScopeMapper tMdBranchScopeMapper;
    private TMdResidentialAreaMapper  tMdResidentialAreaMapper;
    private TSysMessageService messService;
    private TMdBranchMapper branchMapper;
    private TaskExecutor taskExecutor;
    private EcService ecservice;



    @Override
    public int deleteAreaByBranchNo(String branchNo,String residentNoStr) {

        List<String> list = new ArrayList<String>();
        if(StringUtils.isNotBlank(residentNoStr)){
            list = Arrays.asList(residentNoStr.split(","));
        }else{
            throw new ServiceException(MessageCode.LOGIC_ERROR,"参数中没有小区编号");
        }
        try{
            //首先删除奶站和小区的关系
            tMdBranchScopeMapper.deleteAreaByBranchNo(branchNo,list);
            TSysUser sysuser = this.userSessionService.getCurrentUser();
            //然后将小区的状态置为未分配
            if(list.size()>0){
                for(String areaId : list){
                    tMdResidentialAreaMapper.updateStatusToUnDistById(areaId);
                }
              //奶站的配送发生变化，发生系统消息(以线程方式)
                taskExecutor.execute(new Thread(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						super.run();
						this.setName("sendMessagesForBranchDelArea");
						TMdBranch branch = branchMapper.selectBranchByNo(branchNo);
		                if(branch != null){
		                	messService.sendMessagesForUptBranch(branch, 2,sysuser);
		                }
		                //更新奶站小区对应关系
		                for(String areaId : residentNoStr.split(",")){
		                	TMdBranchScopeKey bk = new TMdBranchScopeKey();
		                	bk.setBranchNo(branchNo);
		                	bk.setResidentialAreaId(areaId);
		                	ecservice.senduptBranchScope2Ec(bk, "D");
		                }
					}
                });
            }
        }catch (Exception e){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"删除失败");
        }
        return 1;
    }

    public void settMdBranchScopeMapper(TMdBranchScopeMapper tMdBranchScopeMapper) {
        this.tMdBranchScopeMapper = tMdBranchScopeMapper;
    }

    public void settMdResidentialAreaMapper(TMdResidentialAreaMapper tMdResidentialAreaMapper) {
        this.tMdResidentialAreaMapper = tMdResidentialAreaMapper;
    }

	public void setMessService(TSysMessageService messService) {
		this.messService = messService;
	}

	public void setBranchMapper(TMdBranchMapper branchMapper) {
		this.branchMapper = branchMapper;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void setEcservice(EcService ecservice) {
		this.ecservice = ecservice;
	}
}
