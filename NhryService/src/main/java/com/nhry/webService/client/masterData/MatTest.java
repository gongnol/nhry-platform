package com.nhry.webService.client.masterData;

import com.nhry.webService.client.masterData.functions.ET_MAKTX_type1;
import com.nhry.webService.client.masterData.functions.ZSD_MATERAIL_DATA_RFC;
import com.nhry.webService.client.masterData.functions.ZSD_MATERAIL_DATA_RFCResponse;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;

/**
 * Created by cbz on 6/17/2016.
 */
public class MatTest {
    public static void main(String [] args){
        try{
            String url = "http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=ZT_Q&receiverParty=&receiverService=&interface=ZT_MasterDataQuery&interfaceNamespace=urn%3Anewhopedairy.cn%3AZT%3AMasterData";
            ZT_MasterDataQueryServiceStub client = new ZT_MasterDataQueryServiceStub(url);
            Options options = client._getServiceClient().getOptions();
            HttpTransportPropertiesImpl.Authenticator authenticator1 = new HttpTransportPropertiesImpl.Authenticator();
            authenticator1.setPassword("CANDYTOZT");
            authenticator1.setUsername("ZT_CONN");
            options.setProperty(HTTPConstants.AUTHENTICATE, authenticator1);
            options.setProperty(HTTPConstants.SO_TIMEOUT,new Integer(300000));
            client._getServiceClient().setOptions(options);
            ZSD_MATERAIL_DATA_RFCResponse response ;
            ZSD_MATERAIL_DATA_RFC zsdMaterailDataRfc = new ZSD_MATERAIL_DATA_RFC();
            response = client.mATQUERY(zsdMaterailDataRfc);
            ET_MAKTX_type1 etMaktxType1 = response.getET_MAKTX();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void matHandler(){

    }
}
