package com.demo.microservice.portfolioservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversionUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String objectToJson(Object object) throws Exception {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T jsonToObject(String json, Class<T> valueType) throws Exception {
        return objectMapper.readValue(json, valueType);
    }
}
