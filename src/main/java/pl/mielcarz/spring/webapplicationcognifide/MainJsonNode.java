package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Queue;

public class MainJsonNode {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    JsonNode items;
    JsonNode rootNode;
    ObjectMapper objectMapper;
    File json = new File("books.json");

    public MainJsonNode()throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        rootNode = objectMapper.readTree(json);
        items = rootNode.at("/items").get("volumeInfo");

    }

    public JsonNode readJsonWithJsonNode() throws JsonProcessingException {
        String prettyPrintEmployee = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        logger.info(prettyPrintEmployee+"\n");
        return items ;
    }
}
