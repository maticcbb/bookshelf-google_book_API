package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
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
