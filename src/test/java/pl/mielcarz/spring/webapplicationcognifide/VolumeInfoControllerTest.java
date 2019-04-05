package pl.mielcarz.spring.webapplicationcognifide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.mielcarz.spring.webapplicationcognifide.pojo.VolumeInfo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VolumeInfoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnJsonObjectWithISBN_9780201725933() throws Exception {
        String jsonResult = "[{\"isbn\":\"9780201725933\",\"title\":\"On to Java 2\",\"publisher\":\"Addison Wesley\",\"publishedDate\":978303600,\"description\":\"An introduction to the Java programming language explains how to build complex systems, add tables to graphical interfaces, define layout managers, increase program flexibility, and create network services.\",\"pageCount\":\"451\",\"language\":\"en\",\"previewLink\":\"http://books.google.pl/books?id=biMiAQAAIAAJ&q=java&dq=java&hl=&cd=8&source=gbs_api\",\"averageRating\":0.0,\"authors\":[\"Patrick Henry Winston\",\"Sundar Narasimhan\"],\"categories\":[\"Computers\"]}]";


        this.mvc.perform(get("/books/isbn/9780201725933")).andExpect(status().isOk())
                .andExpect(content().string(jsonResult));
    }

    @Test
    public void shouldReturnJsonObjectWithCategory_Java_Indonesia() throws Exception {
        String jsonResult = "[{\"isbn\":\"gJEC2q7DzpQC\",\"title\":\"The History of Java\",\"publishedDate\":-4417981200,\"pageCount\":\"868\",\"language\":\"en\",\"previewLink\":\"http://books.google.pl/books?id=gJEC2q7DzpQC&printsec=frontcover&dq=java&hl=&cd=3&source=gbs_api\",\"averageRating\":4.5,\"authors\":[\"Sir Thomas Stamford Raffles\"],\"categories\":[\"Java (Indonesia)\"]}]";


        this.mvc.perform(get("/books/category/Java (Indonesia)")).andExpect(status().isOk())
                .andExpect(content().string(jsonResult));
    }

    @Test
    public void shouldReturnJsonObjectWithRatingsAndAuthors() throws Exception {
        String jsonResult = "[[\"Jain Pravin\"],5.0,[\"BUYYA\"],5.0,[\"Sir Thomas Stamford Raffles\"],4.5,[\"Kathy Sierra\",\"Bert Bates\"],4.5,[\"Clifford Geertz\"],4.0,[\"Bruce Eckel\"],4.0,[\"David Flanagan\"],4.0,[\"Douglas Lea\"],4.0,[\"Eric Burke\"],4.0,[\"Kenneth L. Calvert\",\"Michael J. Donahoo\"],4.0,[\"George Reese\"],3.5,[\"Barry Burd\"],3.5,[\"James William Bayley Money\"],1.0,null,0.0,[\"Cay S. Horstmann\",\"Gary Cornell\"],0.0,[\"Cay S. Horstmann\",\"Gary Cornell\"],0.0,[\"Patrick Henry Winston\",\"Sundar Narasimhan\"],0.0,[\"J.F. Scheltema\"],0.0,[\"Benedict Anderson\"],0.0,[\"Nell B. Dale\"],0.0,[\"Roger Garside\",\"John A. Mariani\"],0.0,null,0.0,[\"Jeffrey M. Hunter\"],0.0,[\"David Cousins\"],0.0,[\"praca zbiorowa\"],0.0,[\"Barry A. Burd\"],0.0,[\"Herbert Schildt\"],0.0,[\"Thomas Stamford Raffles\"],0.0,[\"Ann Kumar\"],0.0,[\"Sheng Liang\"],0.0,[\"Dwight Deugo\"],0.0,[\"Alain Trottier\",\"Ed Tittel\"],0.0,null,0.0,null,0.0,[\"David Brackeen\",\"Bret Barker\",\"Laurence Vanhelsuwé\"],0.0,[\"Kenny A. Hunt\"],0.0,[\"Vijay K. Garg\"],0.0,[\"Samuel Auchmuty\"],0.0,[\"Pramoedya Ananta Toer\"],0.0,[\"Janice C. Newberry\"],0.0]";


        this.mvc.perform(get("/books/rating")).andExpect(status().isOk())
                .andExpect(content().string(jsonResult));
    }





}

