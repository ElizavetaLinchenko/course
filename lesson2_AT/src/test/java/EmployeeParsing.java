import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeParsing {

    private static final String rootPath = System.getProperty("user.dir");

    private String expectedCompanySite = "https://www.ikea.com/";

    @Test
    void task1() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File file = new File(rootPath + "/src/test/java/employee.xml");
        Handler handler = new Handler();
        parser.parse(file, handler);
        List<Employees> employees = handler.getEmployeeList();
        Employees lastEmployee = employees.get(employees.size() - 1);
        String actualCompanySite = lastEmployee.getCompanySite();
        assertEquals(expectedCompanySite, actualCompanySite);
    }

    public List<String> task2() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(rootPath + "/src/test/java/employee.xml");
        Document document = builder.parse(file);

        NodeList officeList = document.getElementsByTagName("office");
        List<String> companySites = new ArrayList<>();

        for (int i = 0; i < officeList.getLength(); i++) {
            Element office = (Element) officeList.item(i);
            String floor = office.getAttribute("floor");
            String room = office.getAttribute("room");

            if (floor.equals("1") && room.equals("2")) {
                NodeList employeeList = office.getElementsByTagName("employee");
                for (int y = 0; y < employeeList.getLength(); y++) {
                    Element employee = (Element) employeeList.item(y);
                    String companySite = employee.getAttribute("companySite");
                    companySites.add(companySite);
                }
            }
        }

        for (String companySite : companySites) {
            System.out.println("Company Site: " + companySite);
        }
        return companySites;
    }
}