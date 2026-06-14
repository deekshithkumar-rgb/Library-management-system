package com.pentagon.LibraryManagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pentagon.LibraryManagementsystem.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
