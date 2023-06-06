package com.mds.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mds.demo.dtos.BookDto;
import com.mds.demo.entities.Book;
import com.mds.demo.entities.Role;
import com.mds.demo.entities.User;
import com.mds.demo.repositories.BookRepository;
import com.mds.demo.services.BookService;
import com.mds.demo.services.UserService;

@Controller
@RequestMapping(ActionController.BASE_ROUTE)
public class ActionController {
	public static final String TEMPLATE_NAME = "useraccess";
	public static final String BASE_ROUTE = "useraccess";
	public static final String SELLER_ROUTE = "/seller";
	public static final String CUSTOMER_ROUTE = "/customer";
	public static final String FINDBYPRICE_ROUTE = "/findbyprice";
	public static final String FINDBYNAME_ROUTE = "/findbyname";
	public static final String FINDBYNBPAGES_ROUTE = "/findbynbpages";
	private static final String FLASH_ERRORS = "error";

	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;

	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(value = "login/{id}", method = RequestMethod.GET)
	public String login(@PathVariable final long id, final Model model) {
		String result = "redirect :" + "/user";

		User user = this.userService.findOneUser(id);

		if (user != null) {
			Role role = user.getRole();
			Long myId = user.getId();
			Long SELL = (long) 156;

			if (role.getId() == 156) {
				result = "/" + TEMPLATE_NAME + SELLER_ROUTE;
				try {
					model.addAttribute("books", this.bookService.findBooksOfUser(myId));
				} catch (Exception e) {
					System.out.println("Empty :" + e);
				}

			} else if (role.getId() == 153) {
				result = "/" + TEMPLATE_NAME + CUSTOMER_ROUTE;
				try {
					model.addAttribute("mybooks", this.bookService.findBooksOfUser(myId));
				} catch (Exception e) {
					System.out.println("Empty 2:" + e);
				}
				try {
					model.addAttribute("books", this.bookService.findBooksOfSeller(SELL));
				} catch (Exception e) {
					System.out.println("Empty 2");
				}
			}
			model.addAttribute("user", user);
		} else {
			System.out.println("User doesn't exist");
		}

		return result;
	}

	@RequestMapping(value = "login/{id}/takebooks", method = RequestMethod.GET)
	public String takebook(@PathVariable final long id, final Model model) {
		String result = "redirect :" + "/user";
		result = "/" + TEMPLATE_NAME + "/takebooks";
		User user = this.userService.findOneUser(id);
		try {
			model.addAttribute("books", this.bookService.findBooksOfNobody());
		} catch (Exception e) {
			System.out.println("Empty :" + e);
		}
		model.addAttribute("user", user);

		return result;
	}

	@RequestMapping(value = { "login/{id}/takebooks/{bookId}" }, method = RequestMethod.GET)
	public String takePost(@PathVariable final Long id, @PathVariable final Long bookId,
			final RedirectAttributes attributes) throws Exception {
		String result = "redirect:" + "/useraccess/login/" + id;

		try {
			Book book = this.bookService.findBook(bookId);
			User user = this.userService.findOneUser(id);
			book.setUser(user);
			this.bookRepository.save(book);
		} catch (Exception e) {
			attributes.addFlashAttribute(FLASH_ERRORS, e.getMessage());
			result = "/" + TEMPLATE_NAME + "/create";
		}
		return result;
	}

	@RequestMapping(value = "login/{id}/create", method = RequestMethod.GET)
	public String create(@PathVariable final long id, final Model model) {
		String result = "redirect :" + "/user";
		result = "/" + TEMPLATE_NAME + "/create";

		User user = this.userService.findOneUser(id);

		model.addAttribute("user", user);

		return result;
	}

	@RequestMapping(value = { "login/{id}/create" }, method = RequestMethod.POST)
	public String createPost(BookDto dto, @PathVariable final Long id, final RedirectAttributes attributes)
			throws Exception {
		String result = "redirect:" + "/useraccess/login/" + id;

		try {
			Book book = this.preCreatePost(id, dto);
			this.bookRepository.save(book);
		} catch (Exception e) {
			attributes.addFlashAttribute(FLASH_ERRORS, e.getMessage());
			result = "/" + TEMPLATE_NAME + "/create";
		}
		return result;
	}

	protected Book preCreatePost(@PathVariable final long id, BookDto dto) throws Exception {
		Book book = new Book();
		User user = userService.findOneUser(id);

		book.setName(dto.getName());
		book.setNbPage(dto.getnbPage());
		book.setPrice(dto.getPrice());
		book.setUser(user);

		return book;
	}

	@RequestMapping(value = { "/login/{userId}/findbyprice" }, method = RequestMethod.GET)
	public String priceSearch(@PathVariable final Long userId, final Model model) {
		User user = this.userService.findOneUser(userId);
		model.addAttribute("person", user);

		return TEMPLATE_NAME + FINDBYPRICE_ROUTE;
	}

	@RequestMapping(value = { "/login/{userId}/findbyprice" }, method = RequestMethod.POST)
	public String priceSearchResult(@PathVariable final Long userId, final Model model,
			@RequestParam(required = false) Double price, @RequestParam("priceFilter") String option) {

		String result = "redirect:" + "/useraccess/login/" + userId;

		User user = this.userService.findOneUser(userId);
		model.addAttribute("user", user);

		try {
			if (option.contentEquals("bigger")) {
				List<Book> books = bookService.filterPriceBiggerThan(price);
				model.addAttribute("price", price);
				model.addAttribute("option", option);
				model.addAttribute("books", books);
				result = TEMPLATE_NAME + FINDBYPRICE_ROUTE;
			} else if (option.contentEquals("smaller")) {
				List<Book> books = bookService.filterPriceSmallerThan(price);
				model.addAttribute("price", price);
				model.addAttribute("option", option);
				model.addAttribute("books", books);
				result = TEMPLATE_NAME + FINDBYPRICE_ROUTE;
			}
			if (price.equals(null)) {
				model.addAttribute("errorMessage", "This field cannot be empty");
				result = TEMPLATE_NAME + FINDBYPRICE_ROUTE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "This field cannot be empty");
			result = TEMPLATE_NAME + FINDBYPRICE_ROUTE;
		}
		return result;
	}


	@RequestMapping(value = { "/login/{userId}/findbynbpages" }, method = RequestMethod.GET)
	public String nbpagesSearch(@PathVariable final Long userId, final Model model) {
		User user = this.userService.findOneUser(userId);
		model.addAttribute("user", user);

		return TEMPLATE_NAME + FINDBYNBPAGES_ROUTE;
	}

	@RequestMapping(value = { "/login/{userId}/findbynbpages" }, method = RequestMethod.POST)
	public String nbpagesSearchResult(@PathVariable final Long userId, final Model model,
			@RequestParam(required = false) Integer paj, @RequestParam("filter") String option) {

		String result = "";

		User user = this.userService.findOneUser(userId);
		model.addAttribute("user", user);

		try {
			System.err.println(option);
			if (option.contentEquals("more")) {
				List<Book> books = bookService.filterPagesMoreThan(paj);
				model.addAttribute("paj", paj);
				model.addAttribute("option", option);
				model.addAttribute("books", books);
				result = TEMPLATE_NAME + FINDBYNBPAGES_ROUTE;
			} else if (option.contentEquals("less")) {
				List<Book> books = bookService.filterPagesLessThan(paj);
				model.addAttribute("paj", paj);
				model.addAttribute("option", option);
				model.addAttribute("books", books);
				result = TEMPLATE_NAME + FINDBYNBPAGES_ROUTE;
			}
			if (paj.equals(null)) {
				model.addAttribute("errorMessage", "this field cannot be empty");
				result = TEMPLATE_NAME + FINDBYNBPAGES_ROUTE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "This field cannot be empty");
			result = TEMPLATE_NAME + FINDBYNBPAGES_ROUTE;
		}
		return result;
	}

}
