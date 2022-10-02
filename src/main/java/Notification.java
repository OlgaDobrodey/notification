import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.DateBuilder.dateOf;


public class Notification {


    public static void main(String[] args) throws SchedulerException {
        JobDetail notificationTeamLead = JobBuilder.newJob(NotificationToTeamLead.class)
                .withIdentity("TeamLead Notification")
                .build();

        JobDetail notificationLektor = JobBuilder.newJob(NotificationToLektor.class)
                .withIdentity("Lektor Notification")
                .build();

        Trigger teamLeadTrigger = TriggerBuilder.newTrigger()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInHours(24)).startAt(dateOf(21,59,0))
                .endAt((dateOf(22,0,0)))
                .build();

        Trigger lektorTrigger = TriggerBuilder.newTrigger()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(72)).startAt(dateOf(21,59,00))
                .endAt(dateOf(22,00,00))
                .build();


        SchedulerFactory schFactory = new StdSchedulerFactory();
        Scheduler sch = schFactory.getScheduler();
        sch.scheduleJob(notificationLektor,lektorTrigger);
        sch.scheduleJob(notificationTeamLead, teamLeadTrigger);
        sch.start();
    }
}
