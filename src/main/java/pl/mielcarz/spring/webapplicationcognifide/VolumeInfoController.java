package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.util.List;
import java.io.IOException;

@Controller
public class VolumeInfoController {
    VolumeInfoObjectMapper volumeInfoObjectMapper = new VolumeInfoObjectMapper();



    @RequestMapping(value = "/ex", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePath() throws IOException {
        volumeInfoObjectMapper.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        volumeInfoObjectMapper.readJsonWithObjectMapper();
        System.out.println(volumeInfoObjectMapper.serializeToJsonWithoutNulls());
        return volumeInfoObjectMapper.serializeToJsonWithoutNulls();
    }

    @RequestMapping(value = "/obj", method = RequestMethod.GET)
    @ResponseBody
    public List<VolumeInfo> getFoosBySimpleP() throws IOException {

      volumeInfoObjectMapper.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        volumeInfoObjectMapper.readJsonWithObjectMapper();
        return volumeInfoObjectMapper.volumeInfoList ;
    }
}
