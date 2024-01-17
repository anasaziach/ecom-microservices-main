package ma.ac.emi.ginfo.backend.Controller;

import ma.ac.emi.ginfo.backend.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ma.ac.emi.ginfo.backend.Services.ProductService;
import ma.ac.emi.ginfo.backend.entity.Product;
import ma.ac.emi.ginfo.backend.http.header.HeaderGenerator;

import java.util.Arrays;
import java.util.List;
 
@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private HeaderGenerator headerGenerator;
    @GetMapping (value = "/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products =  productService.getAllProduct();
        System.out.println(products);
        if(!products.isEmpty()) {
        	return new ResponseEntity<List<Product>>(
        			products,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return new ResponseEntity<List<Product>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);       
    }

    @GetMapping("/products/getCategories")
    public List<Category> getCategories(){
        return Arrays.asList(Category.values());
    }

//    @GetMapping(value = "/products/{category}")
//    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){
//        List<Product> products = productService.getProductByCategory(category);
//        if(!products.isEmpty()) {
//        	return new ResponseEntity<List<Product>>(
//        			products,
//        			headerGenerator.getHeadersForSuccessGetMethod(),
//        			HttpStatus.OK);
//        }
//        return new ResponseEntity<List<Product>>(
//        		headerGenerator.getHeadersForError(),
//        		HttpStatus.NOT_FOUND);
//    }
        @GetMapping("/products/category/{category}")
        public List<Product> getProductByCategory(@PathVariable String category){
            return this.productService.getProductByCategory(category);
        }

//    @GetMapping (value = "/products/{id}")
//    public ResponseEntity<Product> getOneProductById(@PathVariable long id){
//        Product product =  productService.getProductById(id);
//        System.out.println(product.toString());
//        if(product != null) {
//        	return new ResponseEntity<Product>(
//        			product,
//        			headerGenerator.getHeadersForSuccessGetMethod(),
//        			HttpStatus.OK);
//        }
//        return new ResponseEntity<Product>(
//        		headerGenerator.getHeadersForError(),
//        		HttpStatus.NOT_FOUND);
//    }
        @GetMapping("/products/id/{id}")
        public Product getProductById(@PathVariable Long id) {
            return productService.getProductById(id);
        }

//    @GetMapping (value = "/products", params = "name")
//    public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam ("name") String name){
//        List<Product> products =  productService.getAllProductsByName(name);
//        if(!products.isEmpty()) {
//        	return new ResponseEntity<List<Product>>(
//        			products,
//        			headerGenerator.getHeadersForSuccessGetMethod(),
//        			HttpStatus.OK);
//        }
//        return new ResponseEntity<List<Product>>(
//        		headerGenerator.getHeadersForError(),
//        		HttpStatus.NOT_FOUND);
//    }
}
