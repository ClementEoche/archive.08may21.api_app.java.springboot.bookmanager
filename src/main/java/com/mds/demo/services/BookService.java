package com.mds.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mds.demo.repositories.BookRepository;
import com.mds.demo.entities.Book;
import com.mds.demo.entities.Role;
import com.mds.demo.entities.User;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	@Autowired
	EntityManager entityManager;

	public Map<Long, String> getTemplateList() {
		Map<Long, String> result = new HashMap<>();

		for (Book item : this.repository.findAll()) {
			result.put(item.getId(), item.getName());
		}

		return result;
	}

	public List<Book> findBooksOfUser(Long userId) {

		List<Book> result = new ArrayList<Book>();

		for (Book item : this.repository.findAll()) {
			User userofthisbook = item.getUser();
			if (userofthisbook != null) {
				if (userofthisbook.getId() == userId) {
					result.add(item);
				}
			}
		}
		System.out.println("books of the user" + result);
		return result;
	}

	public List<Book> findBooksOfSeller(Long sellid) {
		List<Book> result = new ArrayList<Book>();

		for (Book item : this.repository.findAll()) {

			User userofthisbook = item.getUser();

			if (userofthisbook != null) {
				Role userrole = userofthisbook.getRole();

				if (userrole != null) {

					if (userrole.getId() == sellid) {
						result.add(item);
					}
				}
			}
		}
		System.out.println("books of seller" + result);
		return result;
	}

	public List<Book> findBooksOfNobody() {
		List<Book> result = new ArrayList<Book>();

		for (Book item : this.repository.findAll()) {

			User userofthisbook = item.getUser();

			if (userofthisbook == null) {
				result.add(item);
			}
		}
		System.out.println("books of seller" + result);
		return result;
	}

	public Book findBook(final Long bookId) {
		return this.repository.findById(bookId).orElse(null);
	}

	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	public void updateBook(Book book) {
		repository.save(book);
	}

	public void deleteBook(Long bookId) {
		repository.delete(findBook(bookId));
	}

	public List<Book> filterPagesLessThan(int number) {
		Query<Book> query = (Query<Book>) entityManager
				.createQuery("SELECT b FROM Book b where b.nbPage <= :number1", Book.class)
				.setParameter("number1", number);

		List<Book> books = query.getResultList();

		List<Book> result = new ArrayList<>();

		for (Book item : books) {

			User userofthisbook = item.getUser();

			if (userofthisbook != null) {
				Role userrole = userofthisbook.getRole();

				if (userrole != null) {

					if (userrole.getId() == 156) {
						result.add(item);
					}
				}
			}
		}

		return result;
	}

	public List<Book> filterPagesMoreThan(int number) {
		Query<Book> query = (Query<Book>) entityManager
				.createQuery("SELECT b FROM Book b where b.nbPage >= :number2", Book.class)
				.setParameter("number2", number);

		List<Book> books = query.getResultList();

		List<Book> result = new ArrayList<>();

		for (Book item : books) {

			User userofthisbook = item.getUser();

			if (userofthisbook != null) {
				Role userrole = userofthisbook.getRole();

				if (userrole != null) {

					if (userrole.getId() == 156) {
						result.add(item);
					}
				}
			}
		}

		return result;
	}

	public List<Book> filterPriceSmallerThan(double amount) {
		Query<Book> query = (Query<Book>) entityManager
				.createQuery("SELECT b FROM Book b where b.price <= :amount1", Book.class)
				.setParameter("amount1", amount);

		List<Book> books = query.getResultList();

		List<Book> result = new ArrayList<>();

		for (Book item : books) {

			User userofthisbook = item.getUser();

			if (userofthisbook != null) {
				Role userrole = userofthisbook.getRole();

				if (userrole != null) {

					if (userrole.getId() == 156) {
						result.add(item);
					}
				}
			}
		}

		return result;
	}

	public List<Book> filterPriceBiggerThan(double amount) {
		Query<Book> query = (Query<Book>) entityManager
				.createQuery("SELECT b FROM Book b where b.price >= :amount2", Book.class)
				.setParameter("amount2", amount);

		List<Book> books = query.getResultList();

		List<Book> result = new ArrayList<>();

		for (Book item : books) {

			User userofthisbook = item.getUser();

			if (userofthisbook != null) {
				Role userrole = userofthisbook.getRole();

				if (userrole != null) {

					if (userrole.getId() == 156) {
						result.add(item);
					}
				}
			}
		}

		return result;
	}

}
