package com.nhry.common.jedis.cacheloader;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.nhry.common.jedis.entity.StringComplexEntity;
import com.nhry.common.jedis.facade.JedisCacheFacade;
import com.nhry.common.jedis.manager.AbstractJedisCache;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.sqlexecutor.UserSQLExecutor;
import com.nhry.utils.SessionUtil;
 
public class DictionaryJedisCache extends AbstractJedisCache {
	private static final Logger logger = Logger.getLogger(SessionUtil.class);
	
	private String typeCode;
    /**
     * @param COMM_MASTER_DATA_ITEM
     * @param keyFields,keyFields[0]为TYPE_CODE,keyFields[1]为ITEM_CODE
     * @param cls
     */
	public DictionaryJedisCache(String typeCode) {
		this.typeCode=typeCode;
	}
	
//	public synchronized void reload(String cacheKey,SqlSession session) {
//		// TODO Auto-generated method stub
//		String[] keyValues=getKeyValues(cacheKey);
////		SqlSession session= null;
//		try{
////			session= CEUserSessionFactory.openSession();
//			T cacheDataItem =UserSQLExecutor.queryFirst("select * from "+this.COMM_MASTER_DATA_ITEM+" where type_code='"+this.typeCode+"' and " +this.getKeySQL(cacheKey), cls, session);
//			if(cacheDataItem !=null){
//	            cacheDataHash.put(getCacheKeyValue(cacheDataItem), cacheDataItem);
//	            for(int i=0;i<cacheDataList.size();i++){
//	            	if (cacheKey.equalsIgnoreCase(getCacheKeyValue(cacheDataList.get(i)))){
//	            		cacheDataList.remove(i);
//	            	}
//	            }
//	            cacheDataList.add(cacheDataItem);
//			}
//		}catch(Exception e){
//			logger .error("Cache Exception do reload "+this.COMM_MASTER_DATA_ITEM+" Cache error:"+e.getMessage());
//		}finally{
//			//SessionUtil.free(session);
//		}
//	}	
	@Override
	public void reloadAll(SqlSession session){
		try{
			System.out.println(">>>>>>>>>>>>>>>>>>>>初始化字典代码表：" + this.typeCode);
            List<NHSysCodeItem> dataList =UserSQLExecutor.queryList("select * from T_SYS_CODE_ITEM where type_code='"+this.typeCode+"'", NHSysCodeItem.class, session);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + dataList.size());
            //设置首次检查版本时间为当前时间。
            /*更新或插入cache版本begin*/
//            List<SQLParam> sqlParams= new ArrayList<SQLParam>();
//			sqlParams.add(new SQLParam(SQLParam.STRING_TYPE,this.COMM_MASTER_DATA_ITEM));
//            int versionCount = UserSQLExecutor.getTotalCount("select count(*) from T_SYS_VERSION where VERSION_MASTER=?",sqlParams, session);
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + versionCount);
//            List<SQLParam> updateSqlParams= new ArrayList<SQLParam>();
//            updateSqlParams.add(new SQLParam(SQLParam.LONG_TYPE,System.currentTimeMillis()));
//            updateSqlParams.add(new SQLParam(SQLParam.STRING_TYPE,this.COMM_MASTER_DATA_ITEM));
//            String updateSql;
//            if(versionCount>0){
//            	updateSql = "update T_SYS_VERSION set version_no=? where version_master=?";
//            }else{
//            	updateSql = "insert into T_SYS_VERSION(version_no,version_master) values(?, ?)";
//            }
//            UserSQLExecutor.doUpdate(updateSql, updateSqlParams, session);
//            session.commit();
            /*更新或插入cache版本end*/
            
            if (dataList!=null ){
    			logger .error(this.typeCode+" data list is not null");
	            StringComplexEntity scEntity=new StringComplexEntity();
    			for (int i=0;i<dataList.size() ;i++){
    				scEntity.addEntity(dataList.get(i).getItemCode(), dataList.get(i).getItemName());
	            }
                JedisCacheFacade.addToCache("DICTIONARY", this.typeCode, scEntity);
            }
		}catch(Throwable e){
			e.printStackTrace();
			logger .error("Cache Exception do init "+this.typeCode+" Cache error:"+e.getMessage());
		}finally{
			//SessionUtil.free(session);
		}
	}
 

}
