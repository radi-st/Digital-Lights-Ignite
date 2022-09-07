package org.example;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IniFileConfigurationReaderTest {

    @Test
    void createConfigurationWithBothArguments() throws ConfigurationException, IOException {
        String file1 = """
            [log]
            LogPath = C:\\Temp
            LogLevel = WARN""";

        String file2 = """
            [log]
            LogLevel = 4
            LogPath = C:\\Desktop\\logs""";

        String file3 = """
            [log]
            LogPath = D:\\logs
            LogLevel = 5""";


        IniFileConfigurationReader test_reader= new IniFileConfigurationReader();
        ParameterizedTestFileConfigurationReader.createConfigurationWithBothArguments(file1, file2, file3, test_reader);
    }

    @Test
    void createConfigurationWithOneOrMoreArgumentsMissing() {
        String file1 = """
            [log]
            LogLevel = WARN""";

        String file2 = """
            [log]
            LogPath = C:\\Desktop\\logs""";

        String file3 = """
            [log]""";

        String file4="";

        IniFileConfigurationReader test_reader= new IniFileConfigurationReader();
        ParameterizedTestFileConfigurationReader.createConfigurationWithOneOrMoreArgumentsMissing(file1, file2, file3,file4, test_reader);

    }
}