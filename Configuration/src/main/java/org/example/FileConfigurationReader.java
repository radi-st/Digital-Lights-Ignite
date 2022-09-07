package org.example;

import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;

public interface FileConfigurationReader {
    public Configuration createConfiguration(InputStream in) throws ConfigurationException, IOException;
}
