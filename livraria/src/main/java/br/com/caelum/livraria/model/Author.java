package br.com.caelum.livraria.model;

import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ViewScoped
public class Author {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	//Gets && Sets//
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void removeAuthor(Author author) {
		this.author.remove(author);
	}

}
