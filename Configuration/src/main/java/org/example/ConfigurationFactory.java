package org.example;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class ConfigurationFactory {
    public static Configuration create(CommandLine cmd) throws Exception {
        if (cmd.hasOption("configuration")) {
            String filename = cmd.getOptionValue("configuration");
            FileConfigurationReader fcreader = FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename);

            File file = new File(filename);
            InputStream istream = new FileInputStream(file);

            return fcreader.createConfiguration(istream);
        }

        //CommandLine->InputStream?
        return CliConfigurationReader.createConfiguration(cmd);
    }
}
