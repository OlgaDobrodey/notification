import org.quartz.Job;
import org.quartz.JobExecutionContext;


public class NotificationToLektor implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Lektor Trigger");
    }
}
