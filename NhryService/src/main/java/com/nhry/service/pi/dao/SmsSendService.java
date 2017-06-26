package com.nhry.service.pi.dao;

import com.nhry.service.pi.pojo.PIMessage;

/**
 * Created by cbz on 8/10/2016.
 */
public interface SmsSendService {
    PIMessage sendMessage(String context, String tel);
}
