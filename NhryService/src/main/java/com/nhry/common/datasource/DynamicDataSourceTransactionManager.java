package com.nhry.common.datasource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

public class DynamicDataSourceTransactionManager extends
		DataSourceTransactionManager {
	/**
	 * 只读事务到从库
	 * 读写事务到主库
	 */
	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition) {
		boolean readOnly = definition.isReadOnly();
		if(readOnly){
			DataSourceHolder.setSlave();
		}else{
			DataSourceHolder.setMaster();
		}		
		super.doBegin(transaction, definition);
	}
	
	/**
	 * 清理本地线程的数据源
	 */
	@Override
	protected void doCleanupAfterCompletion(Object transaction) {
		super.doCleanupAfterCompletion(transaction);
		DataSourceHolder.clearDataSource();
	}
}
