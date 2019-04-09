package pl.mielcarz.spring.webapplicationcognifide.pojo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.mielcarz.spring.webapplicationcognifide.deserializers.CustomDateDeserializer;
import pl.mielcarz.spring.webapplicationcognifide.pojo.IndustryIdentifier;

import java.util.Arrays;

@JsonPropertyOrder({
        "isbn",
        "title",
        "publisher",
        "subtitle",
        "publishedDate",
        "description",
        "pageCount",
        "thumbnailUrl",
        "language",
        "previewLink",
        "averageRating",
        "authors",
        "categories",

})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VolumeInfo {

    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Long publishedDate;
    private String description;
    private String pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private double averageRating;
    private String[] authors;
    private String[] categories;
    private IndustryIdentifier[] industryIdentifiers;
    private ImageLinks imageLinks;

    public void setIndustryIdentifiers(IndustryIdentifier[] industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public Long getPublisherDate() {
        return publishedDate;
    }

    public void setPublisherDate(Long publisherDate) {
        this.publishedDate = publisherDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getAuthors() {
        String resultString = Arrays.toString(authors);
        resultString = resultString.substring(1, resultString.length()-1);
        return resultString;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    /**
     * Check if {@code singleCategory String}  exist in {@code CategoryArray}
     *
     * @param categoryArray
     * @param singleCategory
     * @return boolean
     */
    public boolean categoryExist(String[] categoryArray, String singleCategory) {
        if (categoryArray == null) {
            return false;
        }
        return Arrays.stream(categoryArray).anyMatch(singleCategory::equals);
    }

    /**
     * Set Id instead of ISBN_13 if its not existing ind object.
     *
     * @return boolean
     */
    @JsonIgnore
    public boolean isbnSetter() {
        for (IndustryIdentifier identifier : industryIdentifiers) {
            if (identifier.isbnExist()) {
                this.isbn = identifier.getIdentifier();
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "VolumeInfo{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", description='" + description + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", language='" + language + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", averageRating=" + averageRating +
                ", authors=" + Arrays.toString(authors) +
                ", categories=" + Arrays.toString(categories) +
                '}';
    }
}


