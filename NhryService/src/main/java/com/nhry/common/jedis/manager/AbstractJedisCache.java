package com.nhry.common.jedis.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public abstract class AbstractJedisCache  implements IJedisCache  {

 	@Override
	public void init(SqlSession session) {
		// TODO Auto-generated method stub
 		reloadAll(session);
	}

	@Override
	public void reloadAll(SqlSession session) {
		// TODO Auto-generated method stub
		
	}

 
}
