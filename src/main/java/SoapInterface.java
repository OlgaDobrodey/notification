import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.soap.SOAPException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

@WebService

@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface SoapInterface {

    @WebMethod
    List<Object> getAllUsers() throws SOAPException, MalformedURLException;

    @WebMethod
    void getAllReportsForThreeDays();

    @WebMethod
    void sendDataToRouter(Object obj);


}
