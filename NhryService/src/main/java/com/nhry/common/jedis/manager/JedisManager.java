package com.nhry.common.jedis.manager;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.nhry.common.jedis.cacheloader.DictionaryJedisCache;
import com.nhry.data.config.domain.NHSysCodeType;
import com.nhry.data.sqlexecutor.UserSQLExecutor;
import com.nhry.utils.SessionUtil;

 
/**
 * 适用场景：
 * 1. 系统参数缓存，
 * 2. 产品数据缓存，产品图片url缓存
 * 3. 产品价格缓存
 * 4. 
 * @author luofuchun
 *
 */
public class JedisManager {
	private static final Logger logger = Logger.getLogger(JedisManager.class);
	private static Object syncObject =new Object();
	private static boolean initFlag =false;

	public static HashMap<String, IJedisCache> jedisCacheMap=new HashMap<String, IJedisCache>();

	public static void registerCacheType(String cacheType,IJedisCache jedisCache){
		jedisCacheMap.put(cacheType, jedisCache);
	}
	
  	
	public  List<NHSysCodeType> geNHSysCodeTypeList(SqlSession session){
		try{
		    return UserSQLExecutor.queryList("select * from T_SYS_CODE_TYPE ", NHSysCodeType.class, session);
		}catch(Throwable t){
			logger.error("geNHSysCodeTypeList error occured !"+t.getMessage());
			return null;
		}
    }
	 
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

//	public JedisManager(
//	SqlSessionFactory sqlSessionFactory){
//		this.sqlSessionFactory=sqlSessionFactory;
//		System.out.println("Jesdis constrcut.................................");
//
//	}

	public  void init(){
		System.out.println("ddcache init>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> thread >>>" +Thread.currentThread().getId());
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<NHSysCodeType> sysCodeTypeList =geNHSysCodeTypeList(session);
			if (sysCodeTypeList !=null){
				//logger.errorT("sysCodeTypeList:size: "+sysCodeTypeList.size());
				for(int i=0;i<sysCodeTypeList .size();i++){
					NHSysCodeType codeType=sysCodeTypeList.get(i);
					//logger.errorT("code type.... : "+codeType);
			    	registerCacheType("DIC_"+codeType.getTypeCode().trim(),new DictionaryJedisCache(codeType.getTypeCode().trim()));
					logger.error("sysCodeTypeList initxxx:"+"DIC"+"_"+codeType.getTypeCode().trim());
					//cacheHash.put("DIC"+"_"+codeType.getTypeCode().trim(), new DICKeyValueDataCache<TSysCodeItem> (codeType.getTypeCode().trim(),TSysCodeItem.class));
				}
			}else{
				logger.error("sysCodeTypeList: is null  ");
			}
			
			initData(session);
			
		} finally {
			SessionUtil.free(session);
			// TODO: handle finally clause
		}
	}
	
	private void initData(SqlSession session){
		logger.error("JedisManager init enter !");
		synchronized (syncObject) {
			if (!initFlag){ 
				logger.error("JedisManager init begin :"+new Timestamp(System.currentTimeMillis()));
				Iterator<String> keyIt =jedisCacheMap.keySet().iterator();
				while (keyIt.hasNext()){
					String cashType=keyIt.next();
					logger.info("cashType inti begin:: "+cashType);
					jedisCacheMap.get(cashType).init(session);
					logger.info("cashType inti end:: "+cashType);
				}
				logger.error("JedisManager init over :"+new Timestamp(System.currentTimeMillis()));
			}
			initFlag =true;
		}
	}


}
