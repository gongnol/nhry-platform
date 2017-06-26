package com.nhry.data.basic.dao;

import java.util.List;

import com.nhry.data.basic.domain.TSysPushMessageLog;

public interface TSysPushMessageLogMapper {
	/**
	 * 删除推送消息的记录
	 * @param mno
	 * @return
	 */
    int delPushMessageLog(String mno);
    
    /**
     * 添加一个推送失败的消息记录
     * @param record
     * @return
     */
    int addPushMessageLog(TSysPushMessageLog record);
    
    /**
     * 根据消息编号查询失败消息记录
     * @param mno
     * @return
     */
    TSysPushMessageLog selectPushMessageLogByNo(String mno);
    
    /**
     * 修改失败消息记录
     * @param record
     * @return
     */
    int updatePushMessageLog(TSysPushMessageLog record);
    
    /**
     * 查询推送失败的消息列表
     * @return
     */
    List<TSysPushMessageLog> findSysPushMessageLogs();
}