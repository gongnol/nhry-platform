package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.data.basic.domain.TSysMessage;
import com.nhry.data.stud.domain.TMdMaraStud;
import com.nhry.model.basic.MessageModel;
import com.nhry.model.basic.OrderModel;

public interface TSysMessageService {
	/**
	 * 根据消息编号删除消息
	 * @param messageNo
	 * @return
	 */
    int delTSysMessageByNo(String messageNo);
    
    /**
     * 添加消息
     * @param record
     * @return
     */
    int addTSysMessage(TSysMessage record);
    
    /**
     * 根据消息编号，查找消息
     * @param messageNo
     * @return
     */
    TSysMessage findTSysmessageByNo(String messageNo);
    
    /**
     * 查询消息
     * @param mess
     * @return
     */
    PageInfo searchMessages(MessageModel mess);
    
    /**
     * 关闭消息
     * @param messageNo
     * @return
     */
    public int closeMessage(String messageNo);
    
    /**
     * 修改消息
     * @param record
     * @return
     */
    int uptTSysMessage(TSysMessage record);
    
    /**
     * 产品发布通知(给奶站内勤发送通知)
     * @param mara
     * @return
     */
    public boolean sendProductsMessages(String title,TMdMara mara,TSysUser user);
    
    /**
     * 新产品添加时给部门内勤发送系统消息
     * @param mara
     * @return
     */
    public boolean sendMessagesForCreateProducts(TMdMara mara);
    
    /**
     * 发送订单备注消息
     * @param om
     * @return
     */
    public boolean sendOrderMemo(OrderModel om);
    
    /**
     * 创建新奶站时给部门内勤发送系统消息    
     * @param branch
     * @return
     */
    public boolean sendMessagesForCreateBranch(TMdBranch branch);
    
    /**
     * 更新奶站信息时给奶站内勤发送系统消息    
     * @param branch
     * @return
     */
    public boolean sendMessagesForUptBranch(TMdBranch branch,int flag,TSysUser user);
    
    /**
     * 奶站员工信息变化发送系统消息
     * @param emp  员工对象
     * @param tag    变化标示(add：新增员工、upt：员工奶站变更奶站)
     * @param user  系统登录人对象
     * @return
     */
    public int sendMessageForEmpUpt(TMdBranchEmp emp,String tag,TSysUser user);

    /**
     * 新产品添加时给部门内勤发送系统消息
     * @param mara
     * @return
     */
    public boolean sendMessagesForCreateProducts(TMdMaraStud mara);
}
