package com.myproject.spring_boot_library.dao;

import com.myproject.spring_boot_library.entity.Book;
import com.myproject.spring_boot_library.projection.BookProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel = "books", path = "books", excerptProjection = BookProjection.class)
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);;

    Page<Book> findByCategory(@RequestParam("category") String category, Pageable pageable);
}
