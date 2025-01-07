package com.myproject.spring_boot_library.dao;

import com.myproject.spring_boot_library.entity.Book;
import com.myproject.spring_boot_library.projection.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books", path = "books", excerptProjection = BookProjection.class)
public interface BookRepository extends JpaRepository<Book, Long> {
}
