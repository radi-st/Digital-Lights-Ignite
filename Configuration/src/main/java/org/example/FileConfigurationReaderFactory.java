package org.example;

import java.lang.reflect.InvocationTargetException;

public class FileConfigurationReaderFactory {
    private  static String extractFileExtension(String filename){
        //get .extension
        String result= filename.substring(filename.lastIndexOf('.'));
        //remove the first character - '.'
        return result.substring(1);
    }

    public static FileConfigurationReader getFileConfigReaderFromFilename(String filename) throws Exception {

            String extension = extractFileExtension(filename);
            extension = extension.substring(0, 1).toUpperCase() + extension.substring(1, extension.length());

            String className = "org.example."+ extension + "FileConfigurationReader";
            Class reader = Class.forName(className);

            if (!FileConfigurationReader.class.isAssignableFrom(reader)) {
                throw new IllegalArgumentException(
                        "Class "
                                + className
                                + " exists but does not implement FileConfigurationReader");
            }
            return (FileConfigurationReader) reader.getConstructor().newInstance();

    }
}
