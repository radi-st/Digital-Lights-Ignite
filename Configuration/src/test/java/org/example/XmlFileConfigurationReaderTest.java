package org.example;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmlFileConfigurationReaderTest {
    @Test
    void createConfigurationWithBothArguments() throws ConfigurationException, IOException {
        String file1= """
                <configuration>
                    <log>
                        <path>C:\\Temp</path>
                        <level>WARN</level>
                    </log>
                </configuration>""";

        String file2= """
                <configuration>
                    <log>
                        <level>4</level>
                        <path>C:\\Desktop\\logs</path>
                    </log>
                </configuration>""";

        String file3= """
                <configuration>
                    <log>
                        <path>D:\\logs</path>
                        <level>5</level>
                    </log>
                </configuration>""";

        XmlFileConfigurationReader test_reader= new XmlFileConfigurationReader();
        ParameterizedTestFileConfigurationReader.createConfigurationWithBothArguments(file1, file2, file3, test_reader);
    }

    @Test
    void createConfigurationWithOneOrMoreArgumentsMissing() {
        String file1= """
                <configuration>
                    <log>
                        <level>WARN</level>
                    </log>
                </configuration>""";


        String file2= """
                <configuration>
                    <log>
                        <path>C:\\Desktop\\logs</path>
                    </log>
                </configuration>""";


        String file3= """
                <configuration>
                    <log>
                    </log>
                </configuration>""";

        String file4= """
                <root>
                </root>""";


        XmlFileConfigurationReader test_reader= new XmlFileConfigurationReader();
        ParameterizedTestFileConfigurationReader.createConfigurationWithOneOrMoreArgumentsMissing(file1, file2, file3,file4, test_reader);

    }
}