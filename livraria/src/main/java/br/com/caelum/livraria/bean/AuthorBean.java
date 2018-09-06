package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.dao.DAO;
import br.com.caelum.livraria.model.Author;
import br.com.caelum.livraria.model.Book;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
public class AuthorBean {
	
	Author author = new Author();
	
	public RedirectView save() {
		System.out.println("Saving author " + this.author.getName());
		if(this.author.getName() == null) {
			new DAO<Author>(Author.class).add(this.author);
			} else {
				new DAO<Author>(Author.class).update(this.author);
			}
		
		this.author = new Author();
		
		return new RedirectView("book");
	}

	//Gets && Sets//
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public void removeAuthor(Author author) {
		System.out.println("Removing " + this.author);
		this.author.removeAuthor(author);
	}
	
	
	public List<Author> getAuthors(){
		return new DAO<Author>(Author.class).listaAll();
	}
	
	

}
