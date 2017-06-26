package com.nhry.data.milktrans.dao;

import com.nhry.data.milktrans.domain.TSsmRedateByTrade;
import java.util.List;

/**
 * Created by cbz on 12/26/2016.
 */
public interface TSsmRedateByTradeMapper {
    int insertRedateByTrade(TSsmRedateByTrade ssmRedateByTrade);
    int updateRedateByTrade(TSsmRedateByTrade ssmRedateByTrade);
    List<TSsmRedateByTrade> findNoSendRedateByTrade();
}
