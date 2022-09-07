package org.example;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileHandler;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class XmlFileConfigurationReader implements FileConfigurationReader {
    @Override
    public Configuration createConfiguration(InputStream in) throws ConfigurationException, IOException {
        XMLConfiguration xml_config= new XMLConfiguration();
        FileHandler fh = new FileHandler(xml_config);
        fh.load(in);
        xml_config.setThrowExceptionOnMissing(true);
        String path=xml_config.getString("log.path");
        String lvl=xml_config.getString("log.level");
        return new XmlConfiguration(path,lvl);
    }
}
