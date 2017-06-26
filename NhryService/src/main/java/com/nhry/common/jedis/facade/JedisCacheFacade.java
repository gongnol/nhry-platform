package com.nhry.common.jedis.facade;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nhry.common.jedis.entity.ComplexEntity;
import com.nhry.common.jedis.entity.StringComplexEntity;
import com.nhry.common.jedis.entity.Test;
import com.nhry.common.jedis.entity.TestComplexEntity;
import com.nhry.utils.json.JackJson;
import com.nhry.utils.redis.JedisPoolManager;

import redis.clients.jedis.Jedis;

/**
 * redis的两种用法 1. 存放HashMap<String,ComplextEntity<T>> 适用于未来的字典代码，等主数据存储. 
 *             2. 粗放HashMap<String,T> 
 * 
 * 存放码表：全部使用StringComplexEntity方式
 * 存放购物车：String ， hashmap<String:sessionid , :购物车对象>
 * @author luofuchun
 *
 */
public class JedisCacheFacade {
    /**
     * 查询接口
     * @param jedis
     * @param cacheTypeId
     * @param key
     * @param cls
     * @return
     * @throws IOException
     */
	public static <E> E fetchCacheObjectValue(Jedis jedis, String cacheTypeId, String key, Class<E> cls)
			throws IOException {
		String result = jedis.hget(cacheTypeId, key);
		
		return JackJson.fromJsonToObject(result, cls);
		
	}

	public static <E> E fetchCacheObjectValue(String cacheTypeId, String key, Class<E> cls) throws IOException {
		Jedis jedis = null;
		try {
			jedis = JedisPoolManager.getJedis();
			return fetchCacheObjectValue(jedis, cacheTypeId, key, cls);
		} finally {
			jedis.close();
		}
	}
	public static String fetchCacheStringValue(Jedis jedis, String cacheTypeId, String key) throws IOException {
		jedis = JedisPoolManager.getJedis();
		String result = jedis.hget(cacheTypeId, key);
		return result;
	}

	public static String fetchCacheStringValue(String cacheTypeId, String key) throws IOException {
		Jedis jedis = null;
		try {
			jedis = JedisPoolManager.getJedis();
			return fetchCacheStringValue(jedis, cacheTypeId, key);
		} finally {
			jedis.close();
		}
	}
/**
 * 添加缓存接口
 * @param jedis
 * @param cacheTypeId
 * @param key
 * @param value
 * @throws IOException
 */
	public static void addToCache(Jedis jedis, String cacheTypeId, String key, String value) throws IOException {
//只是加入HashMap，无需list数据场景。
		if (jedis.exists(cacheTypeId)) {
			Map<String, String> valueMap = jedis.hgetAll(cacheTypeId);
			valueMap.put(key, value);
			jedis.hmset(cacheTypeId, valueMap);
		} else {
			Map<String, String> valueMap = new HashMap<String, String>();
			valueMap.put(key, value);
			jedis.hmset(cacheTypeId, valueMap);
		}

	}

	public static void addToCache(String cacheTypeId, String key, String value) throws IOException {
		Jedis jedis = null;
		try {
			jedis = JedisPoolManager.getJedis();
			addToCache(jedis, cacheTypeId, key, value);
		} finally {
			jedis.close();
		}
	}

	public static void addToCache(String cacheTypeId, String key, Object objValue) throws IOException {
		//只是加入HashMap，需list数据场景，主要适用于码表，和未来的购物车。
		Jedis jedis = null;
		try {
			jedis = JedisPoolManager.getJedis();
			addToCache(jedis, cacheTypeId, key, objValue);
		} finally {
			jedis.close();
		}
	}
/**
 * 获取下拉框数据	
 * @param jedis
 * @param cacheTypeId
 * @param key
 * @return
 * @throws IOException
 */
	public static List<String> getDropdwonListByCacheKey(Jedis jedis, String cacheTypeId, String key) throws IOException {
		List<String> rsList=new ArrayList<String>();
	    
		StringComplexEntity sComplexEntity= JedisCacheFacade.fetchCacheObjectValue(jedis, cacheTypeId, key, StringComplexEntity.class);
	    if (sComplexEntity!=null)
	    for(int i=0;i<sComplexEntity.getListData().size();i++){
	    	rsList.addAll(sComplexEntity.getListData());
	    }
		return rsList;
		
	}

	public static void addToCache(Jedis jedis, String cacheTypeId, String key, Object objValue) throws IOException {

		if (jedis.exists(cacheTypeId)) {
			Map<String, String> valueMap = jedis.hgetAll(cacheTypeId);
			valueMap.put(key, JackJson.fromObjectToJson(objValue));
			jedis.hmset(cacheTypeId, valueMap);
		} else {
			Map<String, String> valueMap = new HashMap<String, String>();
			valueMap.put(key, JackJson.fromObjectToJson(objValue));
			jedis.hmset(cacheTypeId, valueMap);
		}

	}

	/**
	 * 删除接口
	 * @param jedis
	 * @param cacheTypeId
	 * @throws IOException
	 */
		public static void delCacheByCacheType(Jedis jedis, String cacheTypeId) throws IOException {
			jedis.del(cacheTypeId);
		}

		public static void delCacheByCacheType(String cacheTypeId) throws IOException {
			Jedis jedis = null;
			try {
				jedis = JedisPoolManager.getJedis();
				delCacheByCacheType(jedis,cacheTypeId);
			} finally {
				jedis.close();
			}
		}

		public static void delCacheByCacheTypeKey(Jedis jedis, String cacheTypeId, String key) throws IOException {
			Map<String, String> map = jedis.hgetAll(cacheTypeId);
			if (map != null)
				map.remove(key);
			jedis.hmset(cacheTypeId, map);
		}

		public static void delCacheByCacheTypeKey(String cacheTypeId, String key) throws IOException {
			Jedis jedis = null;
			try {
				jedis = JedisPoolManager.getJedis();
				delCacheByCacheTypeKey(jedis,cacheTypeId, key);
			} finally {
				jedis.close();
			}
		}

	public static void main(String[] args) {
		try {
			JedisCacheFacade.addToCache("dic_city", "1001", "中国");
			System.out.println(JedisCacheFacade.fetchCacheStringValue("dic_city", "1001"));
			JedisCacheFacade.addToCache("dic_city", "1002", "中国2");
			System.out.println(JedisCacheFacade.fetchCacheStringValue("dic_city", "1001"));
			System.out.println(JedisCacheFacade.fetchCacheStringValue("dic_city", "1002"));

			
			List<Test> list = new ArrayList<Test>();
			Test test1 = new Test();
			test1.setCode("test1");
			test1.setName("name1");
			test1.setCreateAt(new Timestamp(System.currentTimeMillis()));
			list.add(test1);
			JedisCacheFacade.addToCache("dic_test", "1001", test1);
			//System.out.println(JedisCacheFacade.fetchCacheObjectValue("dic_test", "1001", Test.class).getName());
			Test test2 = new Test();
			test2.setCode("test2");
			test2.setName("name2");
			test2.setCreateAt(new Timestamp(System.currentTimeMillis()));
			
			list.add(test2);
			
			ComplexEntity<Test> ce=new ComplexEntity<Test>();
			ce.addEntity("test1",test1);
			ce.addEntity("test2",test2);
//			ce.setListData(list);
			
			TestComplexEntity tlist = new TestComplexEntity();
			tlist.addEntity("test1",test1);
			tlist.addEntity("test2",test2);
			JedisCacheFacade.addToCache("dic_test", "1002", test2);
			//System.out.println(JedisCacheFacade.fetchCacheObjectValue("dic_test", "1001", Test.class).getName());
			//System.out.println(JedisCacheFacade.fetchCacheObjectValue("dic_test", "1002", Test.class).getName());

			JedisCacheFacade.addToCache("dic_test1", "1008", tlist);
			JedisCacheFacade.addToCache("dic_test1", "1009", ce);
			JedisCacheFacade.addToCache("dic_test1", "1019", "测试1019");

			System.out.println("JedisCacheFacade:"+JedisCacheFacade.fetchCacheStringValue("dic_test1", "1019"));
			//JedisCacheFacade.delCacheByCacheType("dic_test1");
			
			System.out.println(JedisCacheFacade.fetchCacheObjectValue("dic_test1", "1008", TestComplexEntity.class).getListData().get(0).getName());
			System.out.println(JedisCacheFacade.fetchCacheObjectValue("dic_test1", "1008", TestComplexEntity.class).getListData().get(1).getName());
			System.out.println(JedisCacheFacade.fetchCacheObjectValue("dic_test1", "1008", TestComplexEntity.class).getHashData().get("test2").getName());

			StringComplexEntity scEntity =new StringComplexEntity ();
			scEntity .addEntity("1001", "描述","<aaa>2</aaa><bbb>2</bbb>");
			scEntity .addEntity("1002", "<aaa>2</aaa><bbb>2</bbb>");
			
			
			JedisCacheFacade.addToCache("dic_test1", "1010", scEntity);
			
			JedisCacheFacade.addToCache("dic_test1", "1009", ce);
			
			System.out.println(JedisCacheFacade.fetchCacheObjectValue("dic_test1", "1010", StringComplexEntity.class).getListData().get(0));
			//			System.out.println(((Test)JedisCacheFacade.fetchCacheObjectValue("dic_test1", "1009",  ComplexEntity.class).getListData().get(1)).getName());
//			System.out.println(((Test)object).getName());

			// JedisCacheFacade.addToCache("dic_test", "1005", list);
			// JedisCacheFacade.fetchCacheObjectValue("dic_test",
			// "1005",List.class);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		try {
//			
//			List<Test> list = new ArrayList<Test>();
//			Test test1 = new Test();
//			test1.setCode("test1");
//			test1.setName("name1");
//			test1.setCreateAt(new Timestamp(System.currentTimeMillis()));
//			list.add(test1);
//			//System.out.println(JedisCacheFacade.fetchCacheObjectValue("dic_test", "1001", Test.class).getName());
//			Test test2 = new Test();
//			test2.setCode("test2");
//			test2.setName("name2");
//			test2.setCreateAt(new Timestamp(System.currentTimeMillis()));
//			
//			String jsonStr=JackJson.fromObjectToJson(test2);
//			System.out.println("jsonStr:"+jsonStr);
//			Test test3 =JackJson.fromJsonToObject(jsonStr, Test.class);
//			System.out.println("test3:"+test3.getCreateAt());
//			list.add(test2);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

	}

}
