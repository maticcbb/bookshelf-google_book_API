package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.Library;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VolumeInfoObjectMapperTest {

    VolumeInfoObjectMapper volumeInfoObjectMapper = VolumeInfoObjectMapper.getInstance();

    public VolumeInfoObjectMapperTest() throws IOException {

    }

    @Test
    public void volumeInfoObjectMapperShouldNotBeNull() throws IOException {
        volumeInfoObjectMapper.readJsonWithObjectMapper();
        assertNotNull(volumeInfoObjectMapper.getObjectMapper());
        assertNotNull(volumeInfoObjectMapper.serializeToJsonWithoutNulls());
    }
}
