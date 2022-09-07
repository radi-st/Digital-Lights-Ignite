package org.example;
import org.apache.commons.configuration2.JSONConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileHandler;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonFileConfigurationReader implements FileConfigurationReader{
    @Override
    public Configuration createConfiguration(InputStream in) throws ConfigurationException {
        JSONConfiguration json_config= new JSONConfiguration();
        json_config.read(new InputStreamReader(in));
        json_config.setThrowExceptionOnMissing(true);
        String path=json_config.getString("log.path");
        String lvl=json_config.getString("log.level");
        return new JsonConfiguration(path,lvl);
    }
}
