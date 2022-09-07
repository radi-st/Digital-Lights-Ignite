package org.example;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CliConfigurationReaderTest {

    //for testing
    public static Configuration createConfigurationFromArgs(String [] args) throws Exception {
        CommandLine cmd= CliParser.parse(args);
        return CliConfigurationReader.createConfiguration(cmd);
    }
    @Test
    void createConfigurationTestWithBothArgumentsGiven() throws Exception {
        String[] args1 = {"--log-level=5", "--log-path=C:\\Desktop\\logs"};
        String[] args2 = {"--log-path=C:\\logs", "--log-level=WARN"};
        String[] args3 = {"--log-level=WARN", "--log-path=D:\\logs"};

        Configuration config1=createConfigurationFromArgs(args1);
        Configuration config2=createConfigurationFromArgs(args2);
        Configuration config3=createConfigurationFromArgs(args3);

        assertEquals("C:\\Desktop\\logs",config1.getLogFilePath());
        assertEquals("5",config1.getLogLevel());

        assertEquals("C:\\logs",config2.getLogFilePath());
        assertEquals("WARN",config2.getLogLevel());

        assertEquals("D:\\logs",config3.getLogFilePath());
        assertEquals("WARN",config3.getLogLevel());

    }

    @Test
    void createConfigurationTestWithOneOrMoreArgumentMissing() {

        String[] args1 = {"--log-level=5"};
        String[] args2 = {"--log-path=C:\\logs"};
        String[] args3 = {};

        assertThrows(MissingArgumentException.class, ()->createConfigurationFromArgs(args1));
        assertThrows(MissingArgumentException.class, ()->createConfigurationFromArgs(args2));
        assertThrows(MissingArgumentException.class, ()->createConfigurationFromArgs(args3));
    }

}