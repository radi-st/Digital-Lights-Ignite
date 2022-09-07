package org.example;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IniFileConfigurationReader implements FileConfigurationReader{
    @Override
    public Configuration createConfiguration(InputStream in) throws ConfigurationException, IOException {
        INIConfiguration ini_config= new INIConfiguration();
        ini_config.read(new InputStreamReader(in));
        ini_config.setThrowExceptionOnMissing(true);
        String path=ini_config.getString("log.LogPath");
        String lvl=ini_config.getString("log.LogLevel");
        return new IniConfiguration(path,lvl);
    }
}
