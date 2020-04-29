package org.stevexie.jobdetail;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.stevexie.util.DateUtil;

public class DefinedInXMLJobDetail extends QuartzJobBean {
	
	@Override
	protected void executeInternal(JobExecutionContext context) {
		System.out.println("执行在XML中定义好的定时任务，当前时间是：" + DateUtil.currentDatetime());
	}
}
