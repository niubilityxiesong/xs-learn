package selflearning.xs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import selflearning.xs.entity.BlogDetail;

@Repository
public interface BlogDetailRepository extends JpaRepository<BlogDetail, Long> {
}
