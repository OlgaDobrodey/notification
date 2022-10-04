import org.quartz.Job;
import org.quartz.JobExecutionContext;
import services.DummyRouter;
import services.Router;

import java.util.List;

public class SendNotification implements Job {

    private final Router router;

    public SendNotification() {
        this.router = new DummyRouter();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        sendToTeamLead();
        sendToLektor();
    }

    private void sendToTeamLead() {
        List<String> admin = router.getAdmins();
        List<String> untrackedUser = router.getOneDaysNotTrackingUsers();
        if (admin.isEmpty() && untrackedUser.isEmpty()) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String b : untrackedUser) {
            stringBuilder.append(b).append(", ");
        }
        stringBuilder.append("не трекались сегодня ");

        for (String a : admin) {
            router.notifyUser(a, stringBuilder.toString());
        }
    }
    private void sendToLektor() {
        List<String>lektor = router.getLecturers();
        List<String>untrackthreedays = router.getThreeDaysNotTrackingUsers();

        if (lektor.isEmpty() && untrackthreedays.isEmpty()){
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String b : untrackthreedays) {
            stringBuilder.append(b).append(", ");
        }
            stringBuilder.append("не трекались 3 дня");

        for (String a : lektor) {
            router.notifyUser(a, stringBuilder.toString());
        }
    }

}
