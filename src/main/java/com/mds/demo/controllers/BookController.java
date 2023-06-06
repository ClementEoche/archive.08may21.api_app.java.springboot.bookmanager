package com.mds.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mds.demo.entities.Book;

@Controller
@RequestMapping(BookController.BASE_ROUTE)
public class BookController extends BaseCrudController<Book,Book>{
	
	public static final String TEMPLATE_NAME = "book";
	public static final String BASE_ROUTE = "book";

	public BookController() {
		super(TEMPLATE_NAME);
	}
}
