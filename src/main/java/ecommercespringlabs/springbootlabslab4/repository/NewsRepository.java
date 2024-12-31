package ecommercespringlabs.springbootlabslab4.repository;

import ecommercespringlabs.springbootlabslab4.repository.entity.NewsItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsItemEntity, Long> {
    @Query("SELECT n FROM NewsItemEntity n WHERE n.category.id = :categoryId")
    List<NewsItemEntity> findByCategoryId(@Param("categoryId") Long categoryId);
}
