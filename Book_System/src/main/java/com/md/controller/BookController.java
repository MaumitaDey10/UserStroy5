package com.md.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.md.model.Book;
import com.md.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class BookController{
	
	@Autowired
	BookService service;
	
	
	@RequestMapping("/")
	public String viewIndexPage(Model model){
	 List<Book> bookList = service.listAll();
	 model.addAttribute("getAllBook", bookList);
	 return "index";
	}
	
	@RequestMapping("/new_add")
	public String viewNewBookForm(Model model) {
	 Book book = new Book();
	 model.addAttribute("book", book);
	 return "insert";
	}
	
	@RequestMapping(value = "/save_book", method = RequestMethod.POST)
	public String addNewEmployee(@ModelAttribute("book") Book book) {
	 service.create(book);
	 return "redirect:/";

}
}