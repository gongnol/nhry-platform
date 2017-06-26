package com.nhry.webService.client.masterData;

import com.nhry.webService.client.masterData.functions.ET_KUNNR_type1;
import com.nhry.webService.client.masterData.functions.ZSD_CUSTOMER_DATA_SYN_RFC;
import com.nhry.webService.client.masterData.functions.ZSD_CUSTOMER_DATA_SYN_RFCResponse;
import com.nhry.webService.client.masterData.functions.ZSSD00002;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;

/**
 * Created by cbz on 6/17/2016.
 */
public class CustomerDataTest {
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
            ZSD_CUSTOMER_DATA_SYN_RFC zsdCustomerDataSynRfc = new ZSD_CUSTOMER_DATA_SYN_RFC();
            ZSD_CUSTOMER_DATA_SYN_RFCResponse response = new ZSD_CUSTOMER_DATA_SYN_RFCResponse();
//            I_BUKRS_type1 iBukrsType1 = new I_BUKRS_type1();
//            iBukrsType1.setI_BUKRS_type0("0300");
//            zsdCustomerDataSynRfc.setI_BUKRS(iBukrsType1);

            response = client.customerQuery(zsdCustomerDataSynRfc);
            ET_KUNNR_type1 etKunnrType0s = response.getET_KUNNR();
            ZSSD00002[] zssd00002s = etKunnrType0s.getItem();

            for(ZSSD00002 zssd00002 : zssd00002s){
                System.out.println("---------------"+zssd00002.getKUNNR());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
