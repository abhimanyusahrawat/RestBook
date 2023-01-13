package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.Bookrepo;
import com.api.book.entities.Book;
import org.springframework.stereotype.Service;

//can use service to
@Component

public class BookService {


		// why di , hence understand autowiring and
		//remove it
	// remove kiya hai but

	////////////////////
	 //@Autowired
	///////////////// doc bhi padhni hai //////
	private  Bookrepo bookrepo;
	//private static  List<Book>list = new ArrayList<>();

	//@inject
	public BookService(Bookrepo bookrepo)
	 {
		 this.bookrepo=bookrepo;
	 }

	///////
			// why static//
	///////
//	static {
//		list.add(new Book(2,"Cpp book","XYZ"));
//		list.add(new Book(3,"python book","ABC"));
//		list.add(new Book(4,"script book","QWE"));
//	}
//	
	//geting all books
	public List<Book> getAllbooks()
	{
		// why casting??
		return  List.of((Book) this.bookrepo.findAll());
	}
	
	//single book by id 
	public  Book getBookById(int id)
	{
		//if not found so try catch 4 response Entity
	//	book=list.stream().filter(e->e.getId()==id).findFirst().get();
		
			
		return this.bookrepo.findById(id);

	}
	
	//cr8//adding book
	public  Book addBook(Book b) 
	{
	//list.add(b);

		Book save = this.bookrepo.save(b);
		return save;

	}
	
	//deletbook
	
	public void deletBook(int id)
	{
		//list =list.stream().filter(e->e.getId()!= id).collect(Collectors.toList());
		bookrepo.deleteById(id);
		
	}
	//updation//
	public void  updateBook(Book book, int id)
	{
		//map gives 1 ele by 1 ele 
		// updating old list with new list 
//		list =	list.stream().map(e->{
//			if(e.getId() == id)
//			{
//				e.setTitle(book.getTitle());
//				e.setAuthor(book.getAuthor());
//			}
//			
//			return e;
//		}).collect(Collectors.toList());
		
		book.setId(id);
		bookrepo.save(book);
		
	}
}
