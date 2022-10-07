package services;

import java.util.List;

public interface Router {

    void notifyUser(String user, String message);

    List<String> getAdmins();

    List<String> getLecturers();

    List<String> getThreeDaysNotTrackingUsers();

    List<String> getOneDaysNotTrackingUsers();
}
