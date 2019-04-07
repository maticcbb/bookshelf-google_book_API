package pl.mielcarz.spring.webapplicationcognifide;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class VolumeInfoController {

    VolumeInfoObjectMapper volumeInfoObjectMapper;

    {
        try {
            //Initialize one instance of volumeObjectMapper class
            volumeInfoObjectMapper = VolumeInfoObjectMapper.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Return book from list by ISBN (or Id if ISBN not exist).
     *
     * @param id
     * @return resultList
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/books/isbn/{id}", method = GET)
    @ResponseBody
    public List<VolumeInfo> getByISBN(
            @PathVariable("id") String id) throws JsonProcessingException {
        List<VolumeInfo> resultList;

        resultList =
                volumeInfoObjectMapper.serializeToJsonWithoutNulls()
                        .stream()
                        .filter(p -> p.getIsbn().equals(id))
                        .collect(Collectors.toList());

        return resultList;
    }

    /**
     * Return list of books that has category by giving URL parameter.
     *
     * @param category
     * @return resultList
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/books/category/{category}", method = GET)
    public String getByCategory(
            @PathVariable("category") String category , Model model) throws JsonProcessingException {

        List<VolumeInfo> resultList;

        resultList =
                volumeInfoObjectMapper.serializeToJsonWithoutNulls()
                        .stream()
                        .filter(n -> n.categoryExist(n.getCategories(), category))
                        .collect(Collectors.toList());
        // Add list to the view attribute
        model.addAttribute("bookList",resultList);
        // For tests
        return "hello";
    }

    /**
     * Return list of objects with authors and rating properties
     *
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/books/rating", method = GET)
    @ResponseBody
    public List<Serializable> getRatings() throws JsonProcessingException {
        return volumeInfoObjectMapper.serializeToJsonWithoutNulls().stream().sorted(Comparator.comparing(VolumeInfo::getAverageRating).reversed())
                .flatMap(p -> Stream.of(p.getAuthors(), p.getAverageRating()))
                .collect(Collectors.toList());
    }


}
