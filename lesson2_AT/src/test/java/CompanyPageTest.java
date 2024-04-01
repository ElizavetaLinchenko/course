import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
        Спарсите с помощью SAX значения всех параметров companySite из файла employee.xml.
        После того как все url будут спаршены, вам надо написать 3 теста в каждом тесте будет 2 шага.
        1. Перейти по спаршеному url
        2. Проверить, что текущий заголовок страницы не пустой.

        Для шага 1 должен быть отдельный метод в том же классе, где тест. В том методе должна быть реализована логика
        перехода на нужный url.
        Для шага 2 используйте Assertions из junit5.
         */
public class CompanyPageTest {
    private static final String rootPath = System.getProperty("user.dir");

    public List<String> task1() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File file = new File(rootPath + "/src/test/java/employee.xml");
        CompanyPageHandler pageHandler = new CompanyPageHandler();
        parser.parse(file, pageHandler);
        return pageHandler.getSitesList();
    }
}