package pl.mielcarz.spring.webapplicationcognifide.deserializers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomDateDeserializerTest {


    @Test
    public void whenParsingDateShouldConvertToUnixLong() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String json = "{\n" +
                "    \"title\": \"The Religion of Java\",\n" +
                "    \"authors\": [\n" +
                "     \"Clifford Geertz\"\n" +
                "    ],\n" +
                "    \"publisher\": \"University of Chicago Press\",\n" +
                "    \"publishedDate\": \"1976-02-15\"}";

       VolumeInfo volumeInfo = objectMapper.readValue(json, VolumeInfo.class);

        assertEquals(189298800L,volumeInfo.getPublisherDate().longValue());
    }

}