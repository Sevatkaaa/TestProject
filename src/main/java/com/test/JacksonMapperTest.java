package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

public class JacksonMapperTest {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = new Row("123", "eng");
        System.out.println(obj.toString());
        Map map = mapper.convertValue(obj, Map.class);
        System.out.println(map);
    }
}

@Data
@AllArgsConstructor
class Row {
    String keywordId;
    String targetLanguage;
}
