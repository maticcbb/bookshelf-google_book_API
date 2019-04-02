package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class VolumeInfoObjectMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Map<?, ?> viMap = objectMapper.readValue(new File("books.json"), Map.class);
        for (Map.Entry<?, ?> entry : viMap.entrySet()) {

            logger.info("\n--------------------------------\n"+entry.getKey() + "=" + entry.getValue()+"\n");

        }
    }
}