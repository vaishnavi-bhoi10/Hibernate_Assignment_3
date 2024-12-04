package example.hibernet.enitities;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="author_master")
public class Author {
	@Id
	@Column(name = "auth_id", length = 4)
	private int auth_id;
	@Column(name = "auth_name", length = 4)
	private String auth_name;
	@Column(name = "auth_dob")
	private LocalDate auth_dob;
	@Column(name = "auth_country")
	private String country;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Book> books = new ArrayList<>();

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(int auth_id, String auth_name, LocalDate auth_dob, String country, List<Book> books) {
		super();
		this.auth_id = auth_id;
		this.auth_name = auth_name;
		this.auth_dob = auth_dob;
		this.country = country;
		this.books = books;
	}

	public int getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}

	public String getAuth_name() {
		return auth_name;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	public LocalDate getAuth_dob() {
		return auth_dob;
	}

	public void setAuth_dob(LocalDate auth_dob) {
		this.auth_dob = auth_dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		book.setAuthor(this);
		books.add(book);
	}

	public void removeBook(Book book) {
		books.remove(book);
		book.setAuthor(null);
	}

	@Override
	public String toString() {
		return "Author [auth_id=" + auth_id + ", auth_name=" + auth_name + ", auth_dob=" + auth_dob + ", country="
				+ country + ", books=" + books + "]";
	}

	
}
