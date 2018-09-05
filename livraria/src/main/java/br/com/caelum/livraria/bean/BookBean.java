package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.caelum.dao.DAO;
import br.com.caelum.livraria.model.Author;
import br.com.caelum.livraria.model.Book;

@ManagedBean
@ViewScoped
public class BookBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Book book = new Book();
	private Integer authorId;
	
	public void save() {
		System.out.println("Saving book " + this.book.getTitle());
		
		if(book.getAuthors().isEmpty()) {
//			If dont put one author the client give RuntimeException //
//			throw new RuntimeException("The book needs a Author."); //
			FacesContext.getCurrentInstance().addMessage("author", new FacesMessage("Book require at laeast one Author"));
		}
		
		new DAO<Book>(Book.class).add(this.book);
		this.book = new Book();
	}
	
	public String formAuthor() {
		System.out.println("Calling form Author");
		return "author?faces-redirect~true";
	}
	
	//Gets and Sets//
	
	public Book getBook() {
		return book;
	}
	
	public List<Book> getBooks(){
		return new DAO<Book>(Book.class).listaAll();
	}
	
	public List<Author> getAuthors(){
		return new DAO<Author>(Author.class).listaAll();
	}

	public void saveAuthor() {
		Author author = new DAO<Author>(Author.class).searchForId(this.authorId);
		this.book.addAuthor(author);
		System.out.println("Write for: " + author.getName());
	}
	
	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public List<Author> getAuthorsOfBook(){
		return this.book.getAuthors();
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
