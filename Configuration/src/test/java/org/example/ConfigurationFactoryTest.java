package org.example;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationFactoryTest {

    @Test
    void createConfigWithValidArgumentsTest() throws Exception {
        String[] args={"--log-level=warn", "--log-path=C:\\Temp"};
        CommandLine cli_cmd= CliParser.parse(args);
        Configuration cli_config=ConfigurationFactory.create(cli_cmd);

        assertEquals("warn",cli_config.getLogLevel());
        assertEquals("C:\\Temp", cli_config.getLogFilePath());
        assertEquals("class org.example.CliConfiguration",cli_config.getClass().toString());

        /*

        String ini_file = """
            [log]
            LogLevel = 4
            LogPath = C:\\Desktop\\logs""";

        String xml_file = """
                <configuration>
                    <log>
                        <path>D:\\logs</path>
                        <level>5</level>
                    </log>
                </configuration>""";

        String json_file =  """
                {
                  "log": {
                    "path": "C:\\\\Temp",
                    "level": "WARN"
                    }
                 }""";
        */

        // todo tests ini,xml,json
    }

    @Test
    void createConfigWithMissingArguments() throws ParseException {
        String[] args1={"--log-level=warn"};
        String[] args2={"--log-path=C:\\Temp"};
        String[] args3={};
        CommandLine cli_cmd_1= CliParser.parse(args1);
        CommandLine cli_cmd_2= CliParser.parse(args2);
        CommandLine cli_cmd_3= CliParser.parse(args3);

        assertAll("Creating and IniConfig with one or more missing arguments throws",
                ()->assertThrows(MissingArgumentException.class, ()->ConfigurationFactory.create(cli_cmd_1)),
                ()->assertThrows(MissingArgumentException.class, ()->ConfigurationFactory.create(cli_cmd_2)),
                ()->assertThrows(MissingArgumentException.class, ()->ConfigurationFactory.create(cli_cmd_3))
                );


    }
}