package au.id.couter.springbootvuejs.repository;

import au.id.couter.springbootvuejs.domain.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, Long> {
	@Query("FROM Loan l JOIN FETCH l.user u JOIN FETCH l.book WHERE u.id = :userId")
	Iterable<Loan> findByUserId(final Long userId);
}
