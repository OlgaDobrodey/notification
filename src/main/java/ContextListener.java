import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static org.quartz.DateBuilder.dateOf;

public class ContextListener implements ServletContextListener {

    Scheduler sch;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();

        JobDetail notification = JobBuilder.newJob(SendNotification.class)
                .withIdentity("Notification")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInHours(24)).startAt(dateOf(22,0,0))
                .endAt((dateOf(22,0,5)))
                .build();

        SchedulerFactory schFactory = new StdSchedulerFactory();

        try {
            sch = schFactory.getScheduler();
            sch.scheduleJob(notification, trigger);
            sch.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (sch != null) {
            try {
                sch.shutdown();
            } catch (SchedulerException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
