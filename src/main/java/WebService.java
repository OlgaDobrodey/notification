import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceClient;


public class WebService extends SOAPConnection {


    @Override
    public SOAPMessage call(SOAPMessage soapMessage, Object o) throws SOAPException {
        return null;
    }

    @Override
    public void close() throws SOAPException {

    }
}
