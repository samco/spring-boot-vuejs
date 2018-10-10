package au.id.couter.springbootvuejs.domain;

import javax.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private Book book;

	protected Loan() {
	}

	public Loan(User user, Book book) {
		this.user = user;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return new StringBuilder("Loan{").append("id=")
			.append(id)
			.append(", user=")
			.append(user)
			.append(", book=")
			.append(book)
			.append('}')
			.toString();
	}
}
