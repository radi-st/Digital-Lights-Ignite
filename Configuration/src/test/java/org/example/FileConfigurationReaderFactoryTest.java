package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileConfigurationReaderFactoryTest {

    @Test
    void getFileConfigReaderFromFilenameReturnValueIsOfCorrectType() throws Exception {

        String filename_ini1="config.ini";
        String filename_ini2="my_config.xml.ini";
        String filename_json="my_config.json";
        String filename_xml1="configuration.xml";
        String filename_xml2="ini.my_config.xml";

        FileConfigurationReader ini_freader1=FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename_ini1);
        FileConfigurationReader ini_freader2=FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename_ini2);
        FileConfigurationReader json_freader=FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename_json);
        FileConfigurationReader xml_freader1=FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename_xml1);
        FileConfigurationReader xml_freader2=FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename_xml2);

        assertEquals("class org.example.IniFileConfigurationReader", ini_freader1.getClass().toString());
        assertEquals("class org.example.IniFileConfigurationReader", ini_freader2.getClass().toString());
        assertEquals("class org.example.JsonFileConfigurationReader", json_freader.getClass().toString());
        assertEquals("class org.example.XmlFileConfigurationReader", xml_freader1.getClass().toString());
        assertEquals("class org.example.XmlFileConfigurationReader", xml_freader2.getClass().toString());

    }

    @Test
    void getFileConfigReaderFromFilenameThrowsWhenPassedFileWithIncompatibleExtension(){
        String filename1="config.toml";
        String filename2="config.yaml";
        String filename3="my_config.xml.toml";
        String filename4="xml.my_config.yaml";

        assertThrows(ClassNotFoundException.class, ()->FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename1));
        assertThrows(ClassNotFoundException.class, ()->FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename2));
        assertThrows(ClassNotFoundException.class, ()->FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename3));
        assertThrows(ClassNotFoundException.class, ()->FileConfigurationReaderFactory.getFileConfigReaderFromFilename(filename4));
    }
}