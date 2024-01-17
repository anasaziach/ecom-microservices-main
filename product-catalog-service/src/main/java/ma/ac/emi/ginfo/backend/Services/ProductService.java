package ma.ac.emi.ginfo.backend.Services;

import java.util.List;

import ma.ac.emi.ginfo.backend.entity.Category;
import ma.ac.emi.ginfo.backend.entity.Product;



public interface ProductService {
    public List<Product> getAllProduct();
    public List<Product> getProductByCategory(String category);
    public Product getProductById(Long id);
//    public List<Product> getAllProductsByName(String name);
    public Product addProduct(Product product);
    public void deleteProduct(Long productId);
}
