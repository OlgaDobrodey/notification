package services;

import java.util.List;

public class ServerRouter implements Router{
    @Override
    public void notifyUser(String user, String message) {

    }

    @Override
    public List<String> getAdmins() {
        return null;
    }

    @Override
    public List<String> getLecturers() {
        return null;
    }

    @Override
    public List<String> getThreeDaysNotTrackingUsers() {
        return null;
    }

    @Override
    public List<String> getOneDaysNotTrackingUsers() {
        return null;
    }
}
