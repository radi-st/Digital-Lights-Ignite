package org.example;

import org.apache.commons.cli.*;


public class CliConfigurationReader {

    public static Configuration createConfiguration(CommandLine cmd) throws  MissingArgumentException{
        if(!cmd.hasOption("log-path") || !cmd.hasOption("log-level")){
            throw new MissingArgumentException("Missing options with arguments!");
        }

        String log_path= cmd.getOptionValue("log-path");
        String log_lvl= cmd.getOptionValue("log-level");
        //validation?
        return new CliConfiguration(log_path,log_lvl);
    }
}
