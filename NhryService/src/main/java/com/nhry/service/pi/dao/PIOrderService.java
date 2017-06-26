package com.nhry.service.pi.dao;

import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.service.pi.pojo.Order;
import com.nhry.service.pi.pojo.PIReturnMessage;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

/**
 * Created by cbz on 7/20/2016.
 */
@WebService
public interface PIOrderService {
   PIReturnMessage findOrder(@XmlElement(required=true) @WebParam(name = "ORDER_NO")  String ORDER_NO);
}
