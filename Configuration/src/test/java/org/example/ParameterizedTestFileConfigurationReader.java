package org.example;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationTestUtilities {

    public static void assertConfigurationIsReadSuccessfully(String fileContents,
                                                             FileConfigurationReader test_reader,
                                                             String expectedPath,
                                                             String expectedLevel) throws ConfigurationException, IOException {

        ByteArrayInputStream stream = new ByteArrayInputStream(fileContents.getBytes());
        Configuration config = test_reader.createConfiguration(stream);

        assertEquals(expectedPath, config.getLogFilePath());
        assertEquals(expectedLevel, config.getLogLevel());
    }

    public static void assertConfigurationReadingFails(String fileContents, FileConfigurationReader test_reader)
    {
        ByteArrayInputStream stream = new ByteArrayInputStream(fileContents.getBytes());
        assertThrows(NoSuchElementException.class, ()->test_reader.createConfiguration(stream));
    }
}
