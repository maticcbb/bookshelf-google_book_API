package pl.mielcarz.spring.webapplicationcognifide.pojo;

import java.util.ArrayList;
import java.util.List;

public class BooksContainer {
    List<VolumeInfo> BooksContainer;

    public BooksContainer() {
        BooksContainer = new ArrayList<>();
    }

    public List<VolumeInfo> getBooksContainer() {
        return BooksContainer;
    }

    public void setBooksContainer(List<VolumeInfo> booksContainer) {
        BooksContainer = booksContainer;
    }
}
