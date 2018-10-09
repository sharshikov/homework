import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMCreate {
    public static void main(String[] args) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = doc.createElement("progschool");
            doc.appendChild(rootElement);

            Element course = doc.createElement("course");
            rootElement.appendChild(course);

            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            course.setAttributeNode(attr);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode("IAN"));
            course.appendChild(name);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/daksdmkasd.xml"));
            transformer.transform(domSource, result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}