package org.katta.labs.metrics.checkstyle;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CheckstyleLoaderTest {

    @Test
    public void shouldLoadCheckstyleXml() {

        CheckstyleLoader loader = new CheckstyleLoader();
        String filePath = this.getClass().getClassLoader().getResource("checkstyle.xml").getPath();

        Checkstyle checkstyle = loader.load(filePath);

        Assert.assertNotNull(checkstyle);
        List<File> files = checkstyle.getFiles();
        Assert.assertTrue(files.size() > 0);
        Assert.assertTrue(files.get(0).getErrors().size() > 0);
    }
}
