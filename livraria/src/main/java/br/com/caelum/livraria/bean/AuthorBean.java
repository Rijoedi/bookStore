package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.caelum.dao.DAO;
import br.com.caelum.livraria.model.Author;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
public class AuthorBean {
	
	Author author = new Author();
	
	public RedirectView save() {
		System.out.println("Saving book " + this.author.getName());
		new DAO<Author>(Author.class).add(this.author);
		
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
	
	

}
