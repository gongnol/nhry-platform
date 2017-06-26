package com.nhry.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

import com.nhry.common.ladp.LadpService;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.service.external.dao.EcService;

public class Test {

	public static void main(String[] args) {
	  System.out.println(BranchNoUtil.getBranchNo());
	}

}
