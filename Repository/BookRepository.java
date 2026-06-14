package com.pentagon.LibraryManagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pentagon.LibraryManagementsystem.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
