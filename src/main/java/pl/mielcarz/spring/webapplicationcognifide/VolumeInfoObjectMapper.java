package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mielcarz.spring.webapplicationcognifide.pojo.IndustryIdentifier;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VolumeInfoObjectMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper objectMapper;
    private JsonNode jsonNode;

    public void readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<VolumeInfo> volumeInfoList = new ArrayList<>();
        JsonNode root = objectMapper.readTree(new File("books.json")); // read as JsonNode
        JsonNode items = root.at("/items");
        //  System.out.println(items);

        ArrayNode array = (ArrayNode) items;
        array.forEach(n -> {

            VolumeInfo volumeInfo = objectMapper.convertValue(n.get("volumeInfo"), VolumeInfo.class);
            if (!volumeInfo.isbnSetter()) {
                volumeInfo.setIsbn(n.path("id").textValue());
            }


            volumeInfoList.add(volumeInfo);
            System.out.println(volumeInfo);
        });

    }


}


