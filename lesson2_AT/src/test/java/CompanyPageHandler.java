import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CompanyPageHandler extends DefaultHandler {
    private List<String> sitesList = new ArrayList<>();


    public List<String> getSitesList() {
        return sitesList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("employee")) {
            sitesList.add(attributes.getValue("companySite"));
        }
    }
}