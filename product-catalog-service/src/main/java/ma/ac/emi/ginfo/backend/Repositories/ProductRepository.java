package ma.ac.emi.ginfo.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.emi.ginfo.backend.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findAllByCategory(String category);
    public List<Product> findAllByProductName(String name);
}
