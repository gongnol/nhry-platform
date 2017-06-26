package com.nhry.webService;

import com.nhry.utils.EnvContant;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;
import org.apache.log4j.Logger;

/**
 * Created by cbz on 6/23/2016.
 */
public class OptionManager{
    private static Logger logger = Logger.getLogger(OptionManager.class);
    public static Options initializable(Options options){
//        logger.info("---------------------"+EnvContant.getSystemConst("PI.MasterData.USERNAME"));
//        logger.info("---------------------"+EnvContant.getSystemConst("PI.MasterData.PASSWORD"));
        HttpTransportPropertiesImpl.Authenticator authenticator1 = new HttpTransportPropertiesImpl.Authenticator();
        authenticator1.setPassword(EnvContant.getSystemConst("PI.MasterData.PASSWORD"));
        authenticator1.setUsername(EnvContant.getSystemConst("PI.MasterData.USERNAME"));
//        options.setTimeOutInMilliSeconds(600000L);
        int timeOutInMilliSeconds = 3 * 60 * 1000;
        options.setProperty(HTTPConstants.AUTHENTICATE, authenticator1);
        options.setProperty(HTTPConstants.CONNECTION_TIMEOUT,new Integer(timeOutInMilliSeconds));
        options.setProperty(HTTPConstants.SO_TIMEOUT,new Integer(timeOutInMilliSeconds));
        return options;
    }
}
