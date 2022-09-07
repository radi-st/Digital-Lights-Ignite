package org.example;
import org.apache.commons.cli.*;

public class Application {

    public static void main(String[] args) throws ParseException {
        try {
            CommandLine cmd =CliParser.parse(args);
            Configuration config = ConfigurationFactory.create(cmd);
            System.out.println(config.getLogFilePath());
            System.out.println(config.getLogLevel());
        }catch(Exception e){
           System.out.println(e.getMessage());
        }
    }
}