package com.cg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BookShelf {
	
	private List<Book> books = new ArrayList<>();
	
	public List<Book> books() {
		return books;
	}

	public Book addBook(Book b) {
		// TODO Auto-generated method stub
		books.add(b);
		return b;
		
	}

	public List<Book> delBook(Book b) {
		books.remove(b);
		return books;
		
	}

	public List<Book> arrange() {
		Collections.sort(books);
		return books;
		
	}
	
	public List<Book> arrangeOnDateOfReleaseYear() {
		books.sort((o1,o2)->{
			return o1.getReleaseDate().compareTo(o2.getReleaseDate());
		});
		return books;
		
	}
	
//	public List<Book> addBooks(Book...book){
//		return null;
//	}

}
