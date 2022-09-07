package org.example;

abstract class Configuration {
    protected String logFilePath;
    protected String logLevel;

    Configuration(String logFilePath, String logLevel){
        this.logFilePath=logFilePath;
        this.logLevel=logLevel;
    }

    String getLogFilePath(){
        return logFilePath;
    }

    String getLogLevel(){
        return logLevel;
    }
}