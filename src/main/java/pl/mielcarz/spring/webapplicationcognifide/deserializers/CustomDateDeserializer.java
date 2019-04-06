package pl.mielcarz.spring.webapplicationcognifide.deserializers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeserializer extends StdDeserializer<Long> {
    private long unixDate;
    private SimpleDateFormat formatter =
            new SimpleDateFormat("yyyy");

    public CustomDateDeserializer() {
        this(null);
    }

    public CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Long deserialize(JsonParser jsonparser, DeserializationContext context)
            throws IOException, JsonProcessingException {

        String dateString = jsonparser.getText();

        try {
            Date date = formatter.parse(dateString);
            unixDate = (long)date.getTime()/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  unixDate;
    }
}
