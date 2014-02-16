package com.tutorialspoint.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tutorialspoint.entity.Book;

/**
 * Session Bean implementation class LibraryPersistentBean
 */
@Stateful
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

	public LibraryPersistentBean() {
	}

	@PersistenceContext(unitName = "EjbComponentPU")
	private EntityManager entityManager;

	public void addBook(Book book) {
		entityManager.persist(book);
	}

	public List<Book> getBooks() {
		return entityManager.createQuery("From Book").getResultList();
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct:: LibraryPersistentBean session bean"
				+ " created with entity Manager object: ");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy: LibraryPersistentBean session" + " bean is removed ");
	}
}
