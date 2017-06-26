package com.nhry.data.milktrans.impl;

import com.nhry.common.auth.UserSessionService;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.milktrans.dao.TSsmMilkmanAmtInitMapper;
import com.nhry.data.milktrans.domain.TSsmMilkmanAmtInit;
import com.nhry.data.milktrans.domain.TSsmMilkmanAmtInitKey;
import com.nhry.model.statistics.OutMilkModel;
import com.nhry.utils.date.Date;

import java.util.List;

/**
 * Created by huaguan on 2016/12/23.
 */
public class TSsmMilkmanAmtInitMapperImpl implements TSsmMilkmanAmtInitMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;
    private UserSessionService userSessionService;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @Override
    public int insertAmtInit(TSsmMilkmanAmtInit record) {

        return sqlSessionTemplate.insert("insertAmtInit",record);
    }

    /**
     *
     * @return
     */
    @Override
    public List<TSsmMilkmanAmtInit> selectAllAmtInit() {
        return sqlSessionTemplate.selectList("selectAllAmtInit");
    }

    /**
     * 根据奶站查询
     * @param record
     * @return
     */
    @Override
    public List<TSsmMilkmanAmtInit> selectAmtInitByBranchNo(OutMilkModel record) {
        return sqlSessionTemplate.selectList("selectAmtInitByBranchNo",record);
    }

    @Override
    public List<TSsmMilkmanAmtInit> selectAmtInitList(OutMilkModel record) {
        return sqlSessionTemplate.selectList("selectAmtInitList",record);
    }

    @Override
    public int updateAmtInitByPrimaryKeySelective(OutMilkModel record) {
        TSysUser user = userSessionService.getCurrentUser();
        TSsmMilkmanAmtInit tmai = new TSsmMilkmanAmtInit();
        tmai.setBranchNo(record.getBranchNo());
        tmai.setReAmt(record.getReAmt());
        tmai.setEmpNo(record.getEmpNo());
        tmai.setLastModified(new Date());
        tmai.setLastModifiedBy(user.getEmpNo());
        tmai.setLastModifiedByTxt(user.getDisplayName());
        return sqlSessionTemplate.update("updateAmtInitByPrimaryKeySelective",tmai);
    }
}
