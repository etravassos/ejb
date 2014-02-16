package com.tutorialspoint.bean;

import java.util.List;

import javax.ejb.Remote;

import com.tutorialspoint.entity.Book;

@Remote
public interface LibraryPersistentBeanRemote {
	void addBook(Book bookName);

	List<Book> getBooks();
}
