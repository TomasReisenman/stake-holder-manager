package tomas.reisenman.practice;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

    public static String asJsonString(final Object obj) {
        try {

            String valueAsString = new ObjectMapper().writeValueAsString(obj);
            System.out.println("valueAsString = " + valueAsString);
            return valueAsString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
