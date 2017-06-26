package com.nhry.data.basic.impl;

import com.nhry.data.basic.dao.PIProductMapper;
import com.nhry.data.basic.domain.TMdMara;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbz on 6/22/2016.
 */
public class PIProductMapperImpl implements PIProductMapper {
    public static String NAMESPACE = "com.nhry.data.basic.dao.PIProductMapper";

    private SqlSessionFactory sqlSessionFactory;
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    @Override
    public void addProductFromTo(List<TMdMara> tMdMaraList) {
        SqlSession batchSqlSession = null;
        try {
            batchSqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);    //获取批量方式的sqlsession
            int batchCount = 1000;//每批commit的个数
            int batchLastIndex = batchCount - 1;//每批最后一个的下标
            for (int index = 0; index < tMdMaraList.size() - 1; ) {
                if (batchLastIndex > tMdMaraList.size() - 1) {
                    batchLastIndex = tMdMaraList.size() - 1;
                    batchSqlSession.insert(NAMESPACE + ".insertBatch", tMdMaraList.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    System.out.println("insertBatch:" + index + "     batchLastIndex:" + batchLastIndex);
                    break;//数据插入完毕,退出循环
                } else {
                    batchSqlSession.insert(NAMESPACE + ".insertBatch", tMdMaraList.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    System.out.println("insertBatch:" + index + "     batchLastIndex:" + batchLastIndex);
                    index = batchLastIndex + 1;//设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        } finally {
            batchSqlSession.close();
        }
    }

    @Override
    public void updateProductFromTo(List<TMdMara> tMdMaraList) {
        SqlSession batchSqlSession = null;
        try {
            batchSqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);    //获取批量方式的sqlsession
            int batchCount = 1000;//每批commit的个数
            int batchLastIndex = batchCount - 1;//每批最后一个的下标
            for (int index = 0; index < tMdMaraList.size() - 1; ) {
                if (batchLastIndex > tMdMaraList.size() - 1) {
                    batchLastIndex = tMdMaraList.size() - 1;
                    batchSqlSession.insert(NAMESPACE + ".update", tMdMaraList.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    System.out.println("index:" + index + "     batchLastIndex:" + batchLastIndex);
                    break;//数据插入完毕,退出循环
                } else {
                    batchSqlSession.insert(NAMESPACE + ".update", tMdMaraList.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    System.out.println("index:" + index + "     batchLastIndex:" + batchLastIndex);
                    index = batchLastIndex + 1;//设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        } finally {
            batchSqlSession.close();
        }
    }

    @Override
    public List<TMdMara> findAll() {
        SqlSession batchSqlSession = null;
        List<TMdMara> tMdMaras = new ArrayList<TMdMara>();
        try {
            batchSqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
            tMdMaras = batchSqlSession.selectList(NAMESPACE + ".selectAll");
            batchSqlSession.commit();
        } finally {
            batchSqlSession.close();
        }
        return tMdMaras;
    }
}
