package ma.ac.emi.ginfo.backend.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ma.ac.emi.ginfo.backend.Services.ProductService;
import ma.ac.emi.ginfo.backend.entity.Category;
import ma.ac.emi.ginfo.backend.entity.Product;
import ma.ac.emi.ginfo.backend.http.header.HeaderGenerator;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private HeaderGenerator headerGenerator;
    @GetMapping(value = "/products")
    public ResponseEntity<Product> addProduct(
		@RequestParam String title,
        @RequestParam BigDecimal price,
        @RequestParam String description,
        @RequestParam String category,
        @RequestParam boolean disponibility,
        @RequestParam int availability,
        @RequestParam String imgUrl,
		HttpServletRequest request
		){
		Product product = new Product(title,price,description,Category.valueOf(category),disponibility,availability,imgUrl);
		try {
			productService.addProduct(product);
			return new ResponseEntity<Product>(
					product,
					headerGenerator.getHeadersForSuccessPostMethod(request, product.getId()),
					HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Product>(
					headerGenerator.getHeadersForError(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}   
    }
    
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
    	Product product = productService.getProductById(id);
    	if(product != null) {
    		try {
    			productService.deleteProduct(id);
    	        return new ResponseEntity<Void>(
    	        		headerGenerator.getHeadersForSuccessGetMethod(),
    	        		HttpStatus.OK);
    		}catch (Exception e) {
				e.printStackTrace();
    	        return new ResponseEntity<Void>(
    	        		headerGenerator.getHeadersForError(),
    	        		HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<Void>(headerGenerator.getHeadersForError(), HttpStatus.NOT_FOUND);      
    }
}
