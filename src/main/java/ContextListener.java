import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static org.quartz.DateBuilder.dateOf;

public class ContextListener implements ServletContextListener {

    JobDetail notification;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();

        notification = JobBuilder.newJob(SendNotification.class)
                .withIdentity("Notification")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInHours(24)).startAt(dateOf(22,0,0))
                .endAt((dateOf(22,0,5)))
                .build();

        SchedulerFactory schFactory = new StdSchedulerFactory();
        Scheduler sch;
        try {
            sch = schFactory.getScheduler();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
        try {
            sch.scheduleJob(notification, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
        try {
            sch.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
            System.exit(0);
    }
}
