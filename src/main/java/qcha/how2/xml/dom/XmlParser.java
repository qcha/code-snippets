package qcha.how2.xml.dom;

import com.google.common.base.Verify;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class XmlParser {
    private DocumentBuilderFactory documentBuilderFactory;

    public XmlParser() {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
    }

    List<Staff> parse(InputStream is) throws Exception {
        Document doc = documentBuilderFactory.newDocumentBuilder().parse(is);
        doc.getDocumentElement().normalize();

        NodeList staffs = doc.getElementsByTagName("staff");

        List<Staff> staffList = newArrayList();
        for (int i = 0; i < staffs.getLength(); i++) {
            staffList.add(parseStaffNode(staffs.item(i)));
        }

        return staffList;
    }

    private Staff parseStaffNode(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) node;
            Staff staff = new Staff();

            staff.setId(eElement.getAttribute("id"));

            staff.setFirstname(checkAndGetNodeTextContent(eElement.getElementsByTagName("firstname")));
            staff.setLastname(checkAndGetNodeTextContent(eElement.getElementsByTagName("lastname")));
            staff.setNickname(checkAndGetNodeTextContent(eElement.getElementsByTagName("nickname")));
            staff.setSalary(Long.parseLong(checkAndGetNodeTextContent(eElement.getElementsByTagName("salary"))));

            return staff;
        }

        return null;
    }

    private String checkAndGetNodeTextContent(NodeList tags) {
        Verify.verify(tags.getLength() == 1, "Expected only one tag");

        return tags.item(0).getTextContent();
    }
}
