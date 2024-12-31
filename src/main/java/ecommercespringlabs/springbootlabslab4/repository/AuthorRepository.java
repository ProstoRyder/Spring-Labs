package ecommercespringlabs.springbootlabslab4.repository;

import ecommercespringlabs.springbootlabslab4.repository.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
