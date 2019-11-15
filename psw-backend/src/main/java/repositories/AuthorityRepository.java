package repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);
}
