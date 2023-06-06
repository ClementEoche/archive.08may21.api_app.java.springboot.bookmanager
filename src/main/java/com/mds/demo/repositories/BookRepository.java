package com.mds.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mds.demo.entities.Book;


public interface BookRepository extends JpaRepository <Book, Long>{

}
