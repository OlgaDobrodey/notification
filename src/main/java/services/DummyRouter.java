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
        List adminsList = new ArrayList<>();
        adminsList.add("admin");
        adminsList.add("admin2");
        return adminsList;
    }

    @Override
    public List<String> getLecturers() {
        List lecturers = new ArrayList();
        lecturers.add("Lektor");
        lecturers.add("Lektor2");
        return lecturers;
    }

    @Override
    public List<String> getThreeDaysNotTrackingUsers() {
        List untracked = new ArrayList();
        untracked.add("Тема");
        untracked.add("Игорь");
        return untracked;
    }

    @Override
    public List<String> getOneDaysNotTrackingUsers() {
        List fullUntracked = new ArrayList();
        fullUntracked.add("Петя");
        fullUntracked.add("Вася");
        return fullUntracked;
    }
}
