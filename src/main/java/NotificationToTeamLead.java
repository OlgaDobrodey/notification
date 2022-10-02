import org.quartz.*;

public class NotificationToTeamLead implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("TeamLead Trigger");

    }

}
