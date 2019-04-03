package pl.mielcarz.spring.webapplicationcognifide.pojo;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "identifier"
})
public class IndustryIdentifier {

    private String type;
    private String identifier;

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "IndustryIdentifier{" +
                "type='" + type + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }

    /**
     * Check if field type has ISBN_13 property
     * @return boolean
     */
    public boolean isbnExist(){
        if (this.type.equals("ISBN_13")){
            return true;
        }
        else return false;
    }
}
