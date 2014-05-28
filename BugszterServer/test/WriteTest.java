import com.fererlab.dto.Header;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class WriteTest {

    public static void main(String[] args) {

        Header<String, String> map = new Header<String, String>();
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.autodetectAnnotations(true);

        XStream xStreamJSON = new XStream(new JettisonMappedXmlDriver());
        xStreamJSON.autodetectAnnotations(true);

        System.out.println(xstream.toXML(
                map.add("1", "a")
                        .add("2", "b")
                        .add("3", "c")
                        .add("4", "d")
                        .add("5", "e")
        ));
    }

}