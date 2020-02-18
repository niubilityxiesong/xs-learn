package selflearning.xs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import selflearning.xs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
