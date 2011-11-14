package org.katta.labs.metrics.checkstyle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class CheckstyleLoader {

    public Checkstyle load(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Checkstyle.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Checkstyle checkstyle = (Checkstyle) unmarshaller.unmarshal(new File(filePath));
            return checkstyle;
        } catch (Exception e) {
            System.err.println("Error loading the checkstyle files : " + filePath);
            e.printStackTrace();
        }
        return null;
    }
}
