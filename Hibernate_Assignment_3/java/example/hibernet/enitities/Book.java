package example.hibernet.enitities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book_master")
public class Book {

	@Id
	@Column(name = "book_id", length = 4)
	private String book_id;
	@Column(name = "book_title")
	private String book_title;
	@Column(name = "publicationyear", length = 4)
	private int publicationyear;
	@Column(name = "price")
	private double price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String book_id, String book_title, int publicationyear, double price) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.publicationyear = publicationyear;
		this.price = price;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public int getPublicationyear() {
		return publicationyear;
	}

	public void setPublicationyear(int publicationyear) {
		this.publicationyear = publicationyear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_title=" + book_title + ", publicationyear=" + publicationyear
				+ ", price=" + price + "]";
	}

	
	
}
