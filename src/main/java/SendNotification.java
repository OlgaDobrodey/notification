import org.quartz.Job;
import org.quartz.JobExecutionContext;
import services.Router;
import services.ServerRouter;

import java.util.List;

public class SendNotification implements Job {

    private Router router;

    public SendNotification()  {
        this.router = new ServerRouter();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        sendToTeamLead();
        sendToLektor();
        System.out.println("ВЫПОЛНИЛОСЬ");
    }

    private void sendToTeamLead() {
        List<String> teamLeads = router.getAdmins();
        List<String> untrackedUser = router.getOneDaysNotTrackingUsers();
        if (teamLeads.isEmpty() && untrackedUser.isEmpty()) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String b : untrackedUser) {
            stringBuilder.append(b).append(", ");
        }
        stringBuilder.append("не трекались сегодня");

        for (String a : teamLeads) {
            router.notifyUser(a, stringBuilder.toString());

        }
    }
    private void sendToLektor() {
        List<String>lektors = router.getLecturers();
        List<String>untrackthreedays = router.getThreeDaysNotTrackingUsers();

        if (lektors.isEmpty() && untrackthreedays.isEmpty()){
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String b : untrackthreedays) {
            stringBuilder.append(b).append(", ");
        }
            stringBuilder.append("не трекались 3 дня");

        for (String a : lektors) {
            router.notifyUser(a, stringBuilder.toString());
        }
    }

}
