package com.nhry.common.jedis.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface IJedisCache {
	public static final long CHECK_CACHE_INTERVAL =1000*60*15;//每是分钟检查一次cache版本，如果发现变化，则进行更新
//	public long getLastCheckVersionTime();
//	public void setLastCheckVersionTime(long at);
//	public void reset(String cacheKey);
//	public void reset();
//	public long getCacheVersion(SqlSession session);
	//public void reload(String cacheKey, SqlSession session);
	public void init(SqlSession session);
	public void reloadAll(SqlSession session);

}
