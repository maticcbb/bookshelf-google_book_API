package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.util.List;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class VolumeInfoController {

    VolumeInfoObjectMapper volumeInfoObjectMapper;

    {
        try {
            volumeInfoObjectMapper = VolumeInfoObjectMapper.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/ex", method = GET)
    @ResponseBody
    public List<VolumeInfo> getFoosBySimplePath() throws IOException {
        volumeInfoObjectMapper.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        return volumeInfoObjectMapper.serializeToJsonWithoutNulls();
    }

    @RequestMapping(value = "/obj", method = GET)
    @ResponseBody
    public List<VolumeInfo> getFoosBySimpleP() throws IOException {
      volumeInfoObjectMapper.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        return volumeInfoObjectMapper.serializeToJsonWithoutNulls() ;
    }

    @RequestMapping(value = "/ex/obj/{id}", method = GET)
    @ResponseBody
    public List<VolumeInfo> getByISBN(
            @PathVariable("id") String id) throws JsonProcessingException {

        return  volumeInfoObjectMapper.findByISBN(this.volumeInfoObjectMapper,id);
    }

}