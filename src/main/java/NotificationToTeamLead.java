import org.quartz.*;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPMessage;

public class NotificationToTeamLead implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("TeamLead Trigger");


    }

}
