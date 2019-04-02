package pl.mielcarz.spring.webapplicationcognifide.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.mielcarz.spring.webapplicationcognifide.pojo.IndustryIdentifier;


import java.util.Arrays;


    @JsonPropertyOrder({
            "isbn",
            "title",
            "publisher",
            "subtitle",
            "publisher",
            "description",
            "pageCount",
            "thumbnailUrl",
            "language",
            "previewLink",
            "averageRating",
            "authors",
            "categories",
            "industryIdentifiers",
            "publishedDate"

    })
    @JsonInclude(JsonInclude.Include.NON_NULL)

    public class VolumeInfo {


        private String isbn;
        private String title;
        private String subtitle;
        private String publisher;
        private Long publisherDate;
        private String description;
        private String pageCount;
        private String thumbnailUrl;
        private String language;
        private String previewLink;
        private double averageRating;
        private String[] authors;
        private String[] categories;
        private IndustryIdentifier[] industryIdentifierList;


        public IndustryIdentifier[] getIndustryIdentifierList() {
            return industryIdentifierList;
        }

        public void setIndustryIdentifierList(IndustryIdentifier[] industryIdentifierList) {
            this.industryIdentifierList = industryIdentifierList;
        }

        public Long getPublisherDate() {
            return publisherDate;
        }

        public void setPublisherDate(Long publisherDate) {
            this.publisherDate = publisherDate;
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

        public String[] getAuthors() {
            return authors;
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



        @Override
        public String toString() {
            return "VolumeInfo{" +
                    "isbn='" + isbn + '\'' +
                    ", title='" + title + '\'' +
                    ", subtitle='" + subtitle + '\'' +
                    ", publisher='" + publisher + '\'' +
                    ", publisherDate=" + publisherDate +
                    ", description='" + description + '\'' +
                    ", pageCount='" + pageCount + '\'' +
                    ", thumbnailUrl='" + thumbnailUrl + '\'' +
                    ", language='" + language + '\'' +
                    ", previewLink='" + previewLink + '\'' +
                    ", averageRating=" + averageRating +
                    ", authors=" + Arrays.toString(authors) +
                    ", categories=" + Arrays.toString(categories) +
                    ", industryIdentifierList=" + Arrays.toString(industryIdentifierList) +
                    '}';
        }
    }


