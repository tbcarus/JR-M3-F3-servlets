package ru.tbcarus.quest.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ConfigReader {

    public static <T> T readConfig(String fileName, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return objectMapper.readValue(new File(fileName), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}