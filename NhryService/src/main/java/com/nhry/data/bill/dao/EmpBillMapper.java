package com.nhry.data.bill.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.model.bill.EmpAccoDispFeeByProduct;
import com.nhry.model.bill.EmpDispDetialInfoSearch;

import java.util.List;

/**
 * Created by gongjk on 2016/7/1.
 */
public interface EmpBillMapper {
    PageInfo empDispDetialInfo(EmpDispDetialInfoSearch eSearch);

    PageInfo empAccountReceAmount(EmpDispDetialInfoSearch eSearch);

    PageInfo empSalaryRep(EmpDispDetialInfoSearch eSearch);

    List<EmpAccoDispFeeByProduct> empAccoDispFeeByProduct(EmpDispDetialInfoSearch eSearch);

    //获取 一共配送的数量
    int empAccoDispFeeByNum(EmpDispDetialInfoSearch eSearch);

    //获取送奶工内部销售单产品个数
    int empInDispFeeNum(EmpDispDetialInfoSearch eSearch);

    //获取送奶工配送产品个数
    int empDispFeeNum(EmpDispDetialInfoSearch eSearch);

    //获取送奶工赠品配送个数
    int empFreeDispFeeNum(EmpDispDetialInfoSearch eSearch);


    //获取送奶工配送产品和个数详情
    List<EmpAccoDispFeeByProduct> empDisByProduct(EmpDispDetialInfoSearch eSearch);

    //获取送奶工内部销售单配送产品和个数详情
    List<EmpAccoDispFeeByProduct> empInDispByProduct(EmpDispDetialInfoSearch eSearch);

    //获取送奶工赠品配送产品和个数详情
    List<EmpAccoDispFeeByProduct> empFreeDispByProduct(EmpDispDetialInfoSearch eSearch);


}
