import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParser {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/courses.xml");
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("course");
            for (int i = 0; i <nodeList.getLength() ; i++) {
                Node node = nodeList.item(i);
                System.out.println(node.getNodeName());
                Element element = (Element) node;
                element.getAttribute("id");
                element.getElementsByTagName("name").item(0).getTextContent();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
