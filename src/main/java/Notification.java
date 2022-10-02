import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.DateBuilder.dateOf;

public class Notification {

    public static void main(String[] args) throws SchedulerException {
        JobDetail notificationTeamLead = JobBuilder.newJob(NotificationToTeamLead.class)
                .withIdentity("TeamLead Notification")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInHours(24)).startAt(dateOf(21,59,0))
                .endAt((dateOf(22,0,0)))
                .build();



        SchedulerFactory schFactory = new StdSchedulerFactory();
        Scheduler sch = schFactory.getScheduler();
        sch.scheduleJob(notificationTeamLead, trigger);
        sch.start();
    }
}
