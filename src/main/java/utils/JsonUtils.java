package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readJsonFile(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readTree(file);
    }
    public static String convertJsonFileToString(String filePath) throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        return jsonString;
    }
}
