package com.myproject.spring_boot_library.projection;

import com.myproject.spring_boot_library.entity.Book;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "bookProjection", types = { Book.class })
public interface BookProjection {

    Long getId();
    String getTitle();
    String getAuthor();
    String getDescription();
    int getCopies();
    int getCopiesAvailable();
    String getCategory();
    String getImg();
}