package com.nhry.data.basic.dao;

import com.nhry.data.basic.domain.TMdMara;

import java.util.List;

/**
 * Created by cbz on 6/22/2016.
 */
public interface PIProductMapper {
    public void addProductFromTo(List<TMdMara> tMdMaraList);
    public void updateProductFromTo(List<TMdMara> tMdMaraList);
    public List<TMdMara> findAll();

}
