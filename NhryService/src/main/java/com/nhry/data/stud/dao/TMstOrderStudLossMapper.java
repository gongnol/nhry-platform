package com.nhry.data.stud.dao;

import java.util.List;
import java.util.Map;

import com.nhry.data.stud.domain.TMstOrderStudLoss;

public interface TMstOrderStudLossMapper {

    int insertOrderStudLoss(TMstOrderStudLoss orderStudLoss);
    
    int insertOrderStudLossUnpack(TMstOrderStudLoss orderStudLoss);
    
    int insertOrderStudLossFill(TMstOrderStudLoss orderStudLoss);
    
    List<TMstOrderStudLoss> findLossByOrderId(Map<String, Object> selectMap);

	int deleteByOrderIdUnpack(String orderId);
	
	int deleteByOrderIdFill(String orderId);

	List<TMstOrderStudLoss> findLossByOrderIdUnpack(Map<String, Object> selectMap);
	
	List<TMstOrderStudLoss> findLossByOrderIdFill(Map<String, Object> selectMap);

	int deleteByOrderId(String orderId);
}