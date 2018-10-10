package au.id.couter.springbootvuejs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String email;

	protected User() {
	}

	public User(final String name, final String email) {
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return new StringBuilder("User{").append("id=")
			.append(id)
			.append(", name='")
			.append(name)
			.append('\'')
			.append(", email='")
			.append(email)
			.append('\\')
			.append('}')
			.toString();
	}
}
