package com.koreait.jwt_24_10.util.Ut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Ut {
    public static class json {
        public static Object toStr(Map<String,Object> map) {
            try {
                return new ObjectMapper().writeValueAsString(map); // map에 있는 Value를 String으로 바꿔준다.
            } catch (JsonProcessingException e) {
                return null;
            }
        }
    }
}
