package com.md.service;

import com.md.dao.BookDao;
import com.md.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookService {

	@Autowired
	BookDao repo;
	
	public List<Book> listAll(){

		 return repo.findAll();
	}

	
	public void create(Book book) {
		
		repo.save(book);
	}
}
