import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RouterService implements SoapInterface {

    String getAllUsers;
    String ns;

    @Override
    public ArrayList<Object> getAllUsers() throws  MalformedURLException {

         //создаем ссылку на wsdl описание

        URL url = new URL("http://185.46.11.164:8080/manager/html/list");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name

        QName qname = new QName("http://185.46.11.164:8080/", "sender");

        // Теперь мы можем дотянуться до тега service в wsdl описании

        Service service = Service.create(url, qname);

        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса

        RouterService hello = service.getPort(RouterService.class);

        // Ура! Теперь можно вызывать удаленный метод

        ArrayList<Object> arrayList = new ArrayList<>();
        System.out.println(arrayList.isEmpty());
        return arrayList;
    }

    @Override
    public void getAllReportsForThreeDays() {

    }
    @Override
    public void sendDataToRouter(Object obj) {

    }

}
