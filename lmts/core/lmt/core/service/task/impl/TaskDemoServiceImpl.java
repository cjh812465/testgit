package lmt.core.service.task.impl;

import lmt.core.service.task.TaskDemoServiceI;

import org.springframework.stereotype.Service;

@Service
public class TaskDemoServiceImpl implements TaskDemoServiceI {

	@Override
	public void test() {
		System.out.println("定时任务执行...");
	}

}
