package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readJsonFile(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readTree(file);
    }
}
