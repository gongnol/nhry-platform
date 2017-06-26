package com.nhry.service.pi.dao;

/**
 * 满减折扣金额处理类
 * Created by cbz on 12/26/2016.
 */
public interface PIRedateByTradeService {
    /**
     * 定时发送折扣金额到ＣＲＭ或ＥＲＰ
     * @return
     */
    String sendRedateByTradeToCRM();
}
