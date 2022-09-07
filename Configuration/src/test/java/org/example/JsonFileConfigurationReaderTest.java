package org.example;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class JsonFileConfigurationReaderTest {

    @Test
    void createConfigurationWithBothArguments() throws ConfigurationException, IOException {
        String file1 = """
                {
                  "log": {
                    "path": "C:\\\\Temp",
                    "level": "WARN"
                    }
                 }""";

        String file2 = """
                {
                  "log": {
                    "level": "4",
                    "path": "C:\\\\Desktop\\\\logs"
                    }
                 }""";

        String file3 = """
                {
                  "log": {
                    "path": "D:\\\\logs",
                    "level": "5"
                    }
                 }""";

        JsonFileConfigurationReader test_reader= new JsonFileConfigurationReader();
        ParameterizedTestFileConfigurationReader.createConfigurationWithBothArguments(file1, file2, file3, test_reader);
    }

    @Test
    void createConfigurationWithOneOrMoreArgumentsMissing() {
        String file1 = """
                {
                  "log": {
                    "level": "WARN"
                    }
                 }""";

        String file2 = """
                {
                  "log": {
                    "path": "C:\\\\Desktop\\\\logs"
                    }
                 }""";

        String file3 = """
                {
                  "log": {}
                 }""";

        String file4="{}";

        JsonFileConfigurationReader test_reader = new JsonFileConfigurationReader();
        ParameterizedTestFileConfigurationReader.createConfigurationWithOneOrMoreArgumentsMissing(file1, file2, file3,file4, test_reader);

    }

}