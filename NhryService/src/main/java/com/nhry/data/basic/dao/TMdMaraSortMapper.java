package com.nhry.data.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nhry.data.basic.domain.TMdMaraSort;
import com.nhry.model.basic.UpdateMaraModel;
public interface TMdMaraSortMapper {
	
	
  /**
  * 根据matnr和branchno进行排序
  * @param list
  * @return
  */
  int updatebyMatnr(UpdateMaraModel updateMaraModel);
  
  /**
   * 添加
   * @param list
   * @return
   */
  int insert(UpdateMaraModel updateMaraModel);
  /**
   * 根据matnr和branchno进行排序
   * @param list
   * @return
   */
  int delete(UpdateMaraModel list);
  
  List<TMdMaraSort> findListByBranchNo(@Param("branchNo") String branchNo);

  
  
	
}