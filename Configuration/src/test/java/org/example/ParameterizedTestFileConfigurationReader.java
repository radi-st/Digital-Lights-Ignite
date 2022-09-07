package org.example;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTestFileConfigurationReader {

    public static void createConfigurationWithBothArguments(String file1, String file2, String file3, FileConfigurationReader test_reader) throws ConfigurationException, IOException {

        ByteArrayInputStream stream1 = new ByteArrayInputStream(file1.getBytes());
        ByteArrayInputStream stream2 = new ByteArrayInputStream(file2.getBytes());
        ByteArrayInputStream stream3 = new ByteArrayInputStream(file3.getBytes());

        Configuration config1=test_reader.createConfiguration(stream1);
        Configuration config2=test_reader.createConfiguration(stream2);
        Configuration config3=test_reader.createConfiguration(stream3);

        assertEquals("C:\\Temp",config1.getLogFilePath());
        assertEquals("WARN",config1.getLogLevel());

        assertEquals("C:\\Desktop\\logs",config2.getLogFilePath());
        assertEquals("4",config2.getLogLevel());

        assertEquals("D:\\logs",config3.getLogFilePath());
        assertEquals("5",config3.getLogLevel());

    }

    public static void createConfigurationWithOneOrMoreArgumentsMissing(String file1, String file2, String file3,String file4,
                                                                        FileConfigurationReader test_reader) {

        ByteArrayInputStream stream1 = new ByteArrayInputStream(file1.getBytes());
        ByteArrayInputStream stream2 = new ByteArrayInputStream(file2.getBytes());
        ByteArrayInputStream stream3 = new ByteArrayInputStream(file3.getBytes());
        ByteArrayInputStream stream4 = new ByteArrayInputStream(file4.getBytes());

        assertThrows(NoSuchElementException.class, ()->test_reader.createConfiguration(stream1));
        assertThrows(NoSuchElementException.class, ()->test_reader.createConfiguration(stream2));
        assertThrows(NoSuchElementException.class, ()->test_reader.createConfiguration(stream3));
        assertThrows(NoSuchElementException.class, ()->test_reader.createConfiguration(stream4));

    }
    
    
}
