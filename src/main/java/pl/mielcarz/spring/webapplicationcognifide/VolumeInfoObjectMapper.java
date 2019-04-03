package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mielcarz.spring.webapplicationcognifide.pojo.IndustryIdentifier;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VolumeInfoObjectMapper {

    private static VolumeInfoObjectMapper single_instance = null;
    public List<VolumeInfo> volumeInfoList;
    private ObjectMapper objectMapper;
    private JsonNode jsonNode;

    private VolumeInfoObjectMapper() throws IOException {
        this.objectMapper = new ObjectMapper();
        this.volumeInfoList = new ArrayList<>();
        this.readJsonWithObjectMapper();
        serializeToJsonWithoutNulls();

    }

    /**
     * Create only one instance of this class
     * @return {@code single_instance} of class
     * @throws IOException
     */

    public static VolumeInfoObjectMapper getInstance() throws IOException {
        if (single_instance == null)
            single_instance = new VolumeInfoObjectMapper();

        return single_instance;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public List<VolumeInfo> getVolumeInfoList() {
        return volumeInfoList;
    }

    public void setVolumeInfoList(List<VolumeInfo> volumeInfoList) {
        this.volumeInfoList = volumeInfoList;
    }


    /**
     * Read whole book.json file from prepared roots. Making a list of objects and return it. Also check if {@code ISBN_13} property exist, if not set {@code Id} instead of it.
     * @throws IOException
     */
    public void readJsonWithObjectMapper() throws IOException {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/books.json");
        JsonNode root = objectMapper.readTree(inputStream); // read as JsonNode
        JsonNode itemsRoot = root.at("/items");

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
    public List<VolumeInfo> serializeToJsonWithoutNulls() throws JsonProcessingException {

        List<VolumeInfo> filterSortedVolume = Optional.ofNullable(volumeInfoList)
                .orElseGet(Collections::emptyList)
                .stream()
                .collect(Collectors.toList());

        return filterSortedVolume;
    }




}


