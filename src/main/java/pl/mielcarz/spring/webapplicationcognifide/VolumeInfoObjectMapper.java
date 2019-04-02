package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.*;
import java.util.stream.Collectors;

public class VolumeInfoObjectMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper objectMapper;
    private JsonNode jsonNode;
    public List<VolumeInfo> volumeInfoList;


    public void readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        volumeInfoList = new ArrayList<>();
        JsonNode root = objectMapper.readTree(new File("books.json")); // read as JsonNode
        JsonNode itemsRoot = root.at("/items");
        MainJsonNode mainJsonNode = new MainJsonNode();

        ArrayNode array = (ArrayNode) itemsRoot;
        array.forEach(n -> {

            VolumeInfo volumeInfo = objectMapper.convertValue(n.get("volumeInfo"), VolumeInfo.class);
            if (!volumeInfo.isbnSetter()) {
                volumeInfo.setIsbn(n.path("id").textValue());
            }

            volumeInfoList.add(volumeInfo);

        });

    }

    /**
     * Methode get deserialized list of books and return properties and serialized it to JSON wihout null properties.
     */
    public void serializeToJsonWithoutNulls(){

        List<VolumeInfo> filterSortedVolume = Optional.ofNullable(volumeInfoList)
                .orElseGet(Collections::emptyList)
                .stream()
                // .filter(n -> Arrays.stream(n.getAuthors()).anyMatch("Clifford Geertz"::contains)) //filtering null in Strings
                .collect(Collectors.toList()); //back to List of Strings*/

        try {
          objectMapper.writeValueAsString(filterSortedVolume);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


}


