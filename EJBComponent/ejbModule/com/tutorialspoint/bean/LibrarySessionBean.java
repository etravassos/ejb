package com.tutorialspoint.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import com.tutorialspoint.entity.Book;

/**
 * Session Bean implementation class LibrarySessionBean
 */
@Stateful (mappedName = "MeuBeann" )
public class LibrarySessionBean implements LibrarySessionBeanRemote {

	@EJB
	LibraryPersistentBeanRemote libraryPersistentBean;
	
	List<String> bookShelf;

	public LibrarySessionBean() {
		bookShelf = new ArrayList<String>();
	}

	public void addBook(String bookName) {
		
		
		bookShelf.add(bookName);
		
		System.out.println("Add tb no BD:");
		Book b = new Book();
		b.setName(bookName);
		libraryPersistentBean.addBook(b);
	}

	public List<String> getBooks() {
		return bookShelf;
	}

	
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("LibraryStatefulSessionBean.postConstruct::" + " bean created.");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("LibraryStatefulSessionBean.preDestroy:" + " bean removed.");
	}

	@PostActivate
	public void postActivate() {
		System.out.println("LibraryStatefulSessionBean.postActivate:" + " bean activated.");
	}

	@PrePassivate
	public void prePassivate() {
		System.out.println("LibraryStatefulSessionBean.prePassivate:" + " bean passivated.");
	}
}
