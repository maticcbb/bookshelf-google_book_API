package pl.mielcarz.spring.webapplicationcognifide.pojo;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;


public class VolumeInfoTest {

    VolumeInfo volumeInfo = new VolumeInfo();

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Mobile Technologies", "Computer"})
    public void stringsShouldMatchedAndReturnTrue(String singleCategory) {
        String[] categories = {"Java", "Computer", "Dummies", "Mobile Technologies"};

        assertTrue(volumeInfo.categoryExist(categories, singleCategory));
}

   /* @ParameterizedTest
    @MethodSource(value = "provideIsbn")
    public void shouldCheckIfIsbnExist(String singleCategory) {

    }
        static Stream provideIsbn() {
            return Stream.of(
                    Arguments.of(new VolumeInfo()),
                    Arguments.of("kowalski@lol.pl", true),
                    Arguments.of("jan@heheszki.pl", true),
                    Arguments.of("@heheszki.pl", false),
                    Arguments.of("jan@", false)
            );
        }*/
    }


