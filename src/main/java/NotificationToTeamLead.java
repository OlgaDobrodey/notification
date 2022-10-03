import org.quartz.*;

import javax.xml.soap.SOAPException;
import java.net.MalformedURLException;
import java.util.Date;

public class NotificationToTeamLead implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        System.out.println("TeamLead Trigger");
        RouterService routerService = new RouterService();
        try {
            routerService.getAllUsers();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
