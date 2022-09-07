package org.example;

import org.apache.commons.cli.*;

public class CliParser {
    private static Options createOptions(){
        Options options=new Options();
        Option configFileOption = Option.builder()
                .longOpt("configuration")
                .argName("filename" )
                .hasArg()
                .valueSeparator()
                .desc("specifies the file from which the configuration will be imported" )
                .build();

        Option logPathOption = Option.builder()
                .longOpt("log-path")
                .argName("path" )
                .hasArg()
                .valueSeparator()
                .desc("specifies the configuration path" )
                .build();

        Option logLvlOption = Option.builder()
                .longOpt("log-level")
                .argName("level" )
                .hasArg()
                .valueSeparator()
                .desc("specifies the configuration level" )
                .build();

        options.addOption(configFileOption);
        options.addOption(logPathOption);
        options.addOption(logLvlOption);

        return options;
    }

    public static CommandLine parse (String[] args) throws ParseException{
        Options options=createOptions();
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }
}
