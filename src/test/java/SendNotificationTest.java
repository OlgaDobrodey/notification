

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import services.Router;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class SendNotificationTest {

    @Mock
    Router router;

    @InjectMocks
    SendNotification sendNotification = new SendNotification();

    public SendNotificationTest()  {
    }

    @Test
    public void execute() {

        List<String> adminList = new ArrayList<>();
        adminList.add("admin1");
        adminList.add("admin2");
        adminList.add("admin3");

        when(router.getAdmins()).thenReturn(adminList);

        List<String> lektors = new ArrayList<>();
        lektors.add("lektor1");
        lektors.add("lektor2");
        lektors.add("lektor3");

        when(router.getLecturers()).thenReturn(lektors);

        List<String> userLostOneDay = new ArrayList<>();
        userLostOneDay.add("user1");
        userLostOneDay.add("user2");
        userLostOneDay.add("user3");

        when(router.getOneDaysNotTrackingUsers()).thenReturn(userLostOneDay);

        List<String> userLostThreeDay = new ArrayList<>();
        userLostThreeDay.add("user4");
        userLostThreeDay.add("user5");
        userLostThreeDay.add("user6");

        when(router.getThreeDaysNotTrackingUsers()).thenReturn(userLostThreeDay);

        sendNotification.execute(null);


        verify(router,times(1)).notifyUser("admin1", "user1, user2, user3, не трекались сегодня");
        verify(router,times(1)).notifyUser("admin2", "user1, user2, user3, не трекались сегодня");
        verify(router,times(1)).notifyUser("admin3", "user1, user2, user3, не трекались сегодня");

        verify(router,times(1)).notifyUser("lektor1","user4, user5, user6, не трекались 3 дня");
        verify(router,times(1)).notifyUser("lektor2","user4, user5, user6, не трекались 3 дня");
        verify(router,times(1)).notifyUser("lektor3","user4, user5, user6, не трекались 3 дня");

    }
}