package ecommercespringlabs.springbootlabslab4.repository;

import ecommercespringlabs.springbootlabslab4.repository.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
