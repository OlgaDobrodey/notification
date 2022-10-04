package services;


import java.util.ArrayList;
import java.util.List;

public class DummyRouter implements Router{


    @Override
    public void notifyUser(String user, String message) {
        System.out.println("Уведомление " + user + " : " + message);
    }

    @Override
    public List<String> getAdmins() {
        List<String > adminsList = new ArrayList<>();
        adminsList.add("admin");
        adminsList.add("admin2");
        return adminsList;
    }

    @Override
    public List<String> getLecturers() {
        List<String > lecturers = new ArrayList<>();
        lecturers.add("Lektor");
        lecturers.add("Lektor2");
        return lecturers;
    }

    @Override
    public List<String> getThreeDaysNotTrackingUsers() {
        List<String> untrackedThreeDays = new ArrayList<>();
        untrackedThreeDays.add("Тема");
        untrackedThreeDays.add("Игорь");
        return untrackedThreeDays;
    }

    @Override
    public List<String> getOneDaysNotTrackingUsers() {
        List<String > untrackedOneDay = new ArrayList<>();
        untrackedOneDay.add("Петя");
        untrackedOneDay.add("Вася");
        return untrackedOneDay;
    }
}
