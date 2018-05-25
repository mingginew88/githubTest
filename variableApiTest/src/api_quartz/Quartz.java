package api_quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz {
	public static void main(String[] args) {
		JobDetail job = JobBuilder.newJob(QuartzJob.class).build();
		
		Trigger t1 = TriggerBuilder.newTrigger().withIdentity("ConTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0/5 1-59 * * * ? *")).build();
		
		try {
			Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
			sc.start();
			sc.scheduleJob(job, t1);
		} catch (SchedulerException e) {
		}
	}
}

