package ma.ac.emi.ginfo.backend.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ac.emi.ginfo.backend.Repositories.ProductRepository;
import ma.ac.emi.ginfo.backend.entity.Product;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProductsByName(String name) {
        return productRepository.findAllByProductName(name);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
