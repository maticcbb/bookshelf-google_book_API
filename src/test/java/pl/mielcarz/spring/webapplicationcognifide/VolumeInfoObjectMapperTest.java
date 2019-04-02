package pl.mielcarz.spring.webapplicationcognifide;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VolumeInfoObjectMapperTest {

    @Test
    public void testReadJsonAndReturnValidateObject() throws IOException {
        VolumeInfoObjectMapper volumeInfoObjectMapper = new VolumeInfoObjectMapper();
        volumeInfoObjectMapper.readJsonWithObjectMapper();
    }


}