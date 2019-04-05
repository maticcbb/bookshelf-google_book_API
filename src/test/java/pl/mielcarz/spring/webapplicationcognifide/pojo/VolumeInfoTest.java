package pl.mielcarz.spring.webapplicationcognifide.pojo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertTrue;


public class VolumeInfoTest {

    VolumeInfo volumeInfo = new VolumeInfo();

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Mobile Technologies", "Computer"})
    public void stringsShouldMatchedAndReturnTrue(String singleCategory) {
        String[] categories = {"Java", "Computer", "Dummies", "Mobile Technologies"};

       assertTrue(volumeInfo.categoryExist(categories,singleCategory));
    }


}