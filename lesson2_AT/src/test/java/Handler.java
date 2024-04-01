import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {

    private List<Employees> employeeList = new ArrayList<>();
    private Employees currentEmployees;

    public List<Employees> getEmployeeList() {
        return employeeList;
    }

    private static String room = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("office")) {
            room = attributes.getValue("room");
        }

        if (room.equals("2")) {
            if (qName.equals("employee")) {

                String name = attributes.getValue("name");
                String job = attributes.getValue("job");
                String companySite = attributes.getValue("companySite");
                currentEmployees = new Employees(name, job, companySite);
                employeeList.add(currentEmployees);
            }
        }
    }
}