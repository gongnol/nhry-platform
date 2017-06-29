package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.SearchModel.TMdDealerStatusModel;
import com.nhry.data.basic.domain.DealerQueryModel;
import com.nhry.data.basic.domain.TMdDealer;

import java.util.List;

/**
 * Created by gongjk on 2016/7/14.
 */
public interface DealerService {
    List<TMdDealer> getDealerBySalesOrg();

    List<TMdDealer> getDealerOnAuth();

	PageInfo findDealerListByPage(DealerQueryModel sModel);

	List<TMdDealer>  getDealersBySalesOrg(String salesOrg);

	int addDealer(TMdDealer dealer);

	TMdDealer selectDealerByNo(String dealerNo);

	int updateDealerStatus(TMdDealerStatusModel model);

	List<TMdDealer> getDealerOnAuthAndGroup(String branchGroup);
}
