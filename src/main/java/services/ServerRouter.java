package services;

import com.example.generate.ListOfString;
import com.example.generate.RouterSenderServiceImplService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServerRouter implements Router{

    URL url;

    RouterSenderServiceImplService service;

    public ServerRouter() {
        try {
            url = new URL("http://localhost:8082/ws/router?wsdl");
            service = new RouterSenderServiceImplService(url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void notifyUser(String user, String message) {
        service.getRouterSenderServiceImplPort().notifyUser(user,message);
    }

    @Override
    public List<String> getAdmins() {
        ListOfString list = service.getRouterSenderServiceImplPort().getAdmins();
        return list.getItem();
    }

    @Override
    public List<String> getLecturers() {
        ListOfString list = service.getRouterSenderServiceImplPort().getLecturers();
        return list.getItem();
    }

    @Override
    public List<String> getThreeDaysNotTrackingUsers() {
        ListOfString list = service.getRouterSenderServiceImplPort().getThreeDaysNotTrackingUsers();
        return list.getItem();
    }

    @Override
    public List<String> getOneDaysNotTrackingUsers() {
        ListOfString list = service.getRouterSenderServiceImplPort().getOneDaysNotTrackingUsers();
        return list.getItem();
    }
}
