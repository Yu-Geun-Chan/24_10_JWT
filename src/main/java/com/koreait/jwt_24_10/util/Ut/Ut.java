package com.koreait.jwt_24_10.util.Ut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ut {
    public static class json {
        public static Object toStr(Map<String, Object> map) {
            try {
                return new ObjectMapper().writeValueAsString(map); // map에 있는 Value를 String으로 바꿔준다.
            } catch (JsonProcessingException e) {
                return null;
            }
        }

        public static Map<String, Object> toMap(String jsonStr) {
            try {
                return new ObjectMapper().readValue(jsonStr, LinkedHashMap.class); // String으로 바꾼걸 다시 Map으로
            } catch (JsonProcessingException e) {
                return null;
            }
        }
    }
}
