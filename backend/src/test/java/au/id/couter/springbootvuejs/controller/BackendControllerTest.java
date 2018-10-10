package au.id.couter.springbootvuejs.controller;

import au.id.couter.springbootvuejs.SpringBootVuejsApplication;
import au.id.couter.springbootvuejs.domain.User;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootVuejsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
public class BackendControllerTest {

	@LocalServerPort
	private int port;

	@Before
	public void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	public void retrieveUsers() {
		final User[]
			responseUsers =
			given().when()
				.get("/api/users")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.assertThat()
				.extract()
				.as(User[].class);

		responseUsers[0].getEmail().equals("norbert@example.com");
	}

}
