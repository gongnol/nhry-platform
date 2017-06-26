package com.nhry.data.basic.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdMaraMapper;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.model.basic.ProductQueryModel;
import com.nhry.model.basic.UpdateMaraModel;

public class TMdMaraMapperImpl implements TMdMaraMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public TMdMara selectProductByCode(Map<String,String> attrs) {
        // TODO Auto-generated method stub
        return this.sqlSessionTemplate.selectOne("selectProductByCode", attrs);
    }

    @Override
    public int uptProductByCode(TMdMara record) {
        // TODO Auto-generated method stub
        return this.sqlSessionTemplate.update("uptProductByCode", record);
    }


    @Override
    public PageInfo searchProducts(ProductQueryModel smodel) {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.selectListByPages("searchProducts", smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
    }

    @Override
    public List<TMdMara> selectProductAndExListByCode(Map<String,String> attrs) {
        return this.sqlSessionTemplate.selectList("selectProductAndExListByCode", attrs);
    }

    @Override
    public int addProduct(TMdMara tMdMara) {
        return sqlSessionTemplate.insert("addProduct",tMdMara);
    }

    @Override
    public int updateProduct(TMdMara tMdMara) {
        return sqlSessionTemplate.update("updateProduct",tMdMara);
    }

    @Override
    public int isProduct(String id) {
        return sqlSessionTemplate.selectOne("isProduct",id);
    }

    @Override
    public TMdMara selectProductAndExByCode(Map<String,String> attrs) {
        // TODO Auto-generated method stub
        return this.sqlSessionTemplate.selectOne("selectProductAndExByCode", attrs);
    }

    @Override
    public int pubProductByCode(Map<String,String> attrs) {
        // TODO Auto-generated method stub
        return this.sqlSessionTemplate.update("pubProductByCode", attrs);
    }

	@Override
	public PageInfo getDealerMaras(ProductQueryModel pm) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectListByPages("getDealerMaras", pm,Integer.parseInt(pm.getPageNum()),Integer.parseInt(pm.getPageSize()));
	}
	
	public List<TMdMara> getDealerMarasList(ProductQueryModel pm) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getDealerMaras", pm);
	}

	@Override
	public PageInfo getCompMaras(ProductQueryModel pm) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectListByPages("getCompMaras",pm,Integer.parseInt(pm.getPageNum()),Integer.parseInt(pm.getPageSize()));
	}
	
	@Override
	public List<TMdMara> getCompMarasList(ProductQueryModel pm) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getCompMaras",pm);
	}

    @Override
    public List<TMdMara>  getProductByCodeOrNameAndSalesOrg(Map<String,String> attrs) {
        return this.sqlSessionTemplate.selectList("getProductByCodeOrNameAndSalesOrg", attrs);
    }

    @Override
    public PageInfo listsBySalesOrg(ProductQueryModel pm) {
        return this.sqlSessionTemplate.selectListByPages("listsBySalesOrg",pm,Integer.parseInt(pm.getPageNum()),Integer.parseInt(pm.getPageSize()));
    }

    @Override
	public List<TMdMara> findMarasBySalesCodeAndOrg(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findMarasBySalesCodeAndOrg", attrs);
	}
    
    @Override
    public int updateSort(UpdateMaraModel UpdateMaraModel) {
    	 return this.sqlSessionTemplate.update("updateSort",UpdateMaraModel);
    }
}
