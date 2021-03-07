package com.cg;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BookShelfSpec {
	private BookShelf shelf1;
	
	//this method will get invoked the minute this class gets loaded into the memory and before running other tests
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Runs before all the test");
	}
	
	//when this class is finished executing all tests
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Testing completed!");
	}
	
	
	
	//before each test
	@BeforeEach
	void setUp() throws Exception {
		shelf1 = new BookShelf();
		System.out.println("Testing started for next ...");
	}
	
	@Nested
	@DisplayName("is Empty")
	
	class isEmpty{
		
		@Test
		void test() {
			assertEquals(Collections.EMPTY_LIST,new BookShelf().books());
		}
		
		@Test
		@DisplayName("when add is called without book")
		public void emptyBookShelfWhenNoBookAdded() {
			List<Book> bks = shelf1.books();
			assertTrue(bks.isEmpty(),() -> "BookShelf should be empty");
		}
	}
	

	//after the completion of each test
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Testing ended...");
	}

	@Nested
	@DisplayName("For add and delete")

		class addOrDelete{
		
		@Test
		void testAddBooks() {
			
			shelf1.addBook(new Book());
			shelf1.addBook(new Book());
			shelf1.addBook(new Book());
			
			assertEquals(3, shelf1.books().size());
		}
		
//		@Test
//		void testAddBooksStream() {
//			
//			List<Book> tempList = new ArrayList<>();
//			tempList.add(new Book());
//			tempList.add(new Book());
//			shelf1.addBook(new Book());
//			shelf1.addBook(new Book());
//			shelf1.addBook(new Book());
//			
//			assertEquals(3, new BookShelf().addBooks(tempList.stream().collect(Collectors.toList())) );
//		}
		
		
		
		@Test
		void testDelBook() {
			shelf1 = new BookShelf();
			Book b1 = new Book(111,"Java",new Author(),LocalDate.now());
			Book b2 = new Book(112,"oracle",new Author(),LocalDate.of(2021, 2, 3));
			Book b3 = new Book(113,"ASP",new Author(),LocalDate.of(220, 1, 23));
			shelf1.addBook(b1);
			shelf1.addBook(b2);
			shelf1.addBook(b3);
			
			int originalSize = shelf1.books().size();
			shelf1.delBook(b1);
			
			int newSize = shelf1.books().size();
			
			assertEquals(originalSize, newSize+1);
		}
		
		
	}

	@Test
	void testArrangement() {
		//arrange() method is arranging the books on the basis of their title or not
		shelf1 = new BookShelf();
		Book b1 = new Book(111,"Java",new Author(),LocalDate.now());
		Book b2 = new Book(112,"oracle",new Author(),LocalDate.of(2021, 2, 3));
		Book b3 = new Book(113,"ASP",new Author(),LocalDate.of(220, 1, 23));
		shelf1.addBook(b3);
		shelf1.addBook(b1);
		shelf1.addBook(b2);
		
		BookShelf unarranged = new BookShelf();
		unarranged.addBook(b1);
		unarranged.addBook(b2);
		unarranged.addBook(b3);
		
		assertEquals(shelf1.books(), unarranged.arrange());
	}
	
	@Test
	void testArrangementDate() {
		//arrange() method is arranging the books on the basis of their title or not
		shelf1 = new BookShelf();
		Book b1 = new Book(111,"Java",new Author(),LocalDate.now());
		Book b2 = new Book(112,"oracle",new Author(),LocalDate.of(2021, 2, 3));
		Book b3 = new Book(113,"ASP",new Author(),LocalDate.of(220, 1, 23));
		shelf1.addBook(b3);
		shelf1.addBook(b2);
		shelf1.addBook(b1);
		
		BookShelf unarranged = new BookShelf();
		unarranged.addBook(b1);
		unarranged.addBook(b2);
		unarranged.addBook(b3);
		
		assertEquals(shelf1.books(), unarranged.arrangeOnDateOfReleaseYear());
	}


}
