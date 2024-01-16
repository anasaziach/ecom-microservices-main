package ma.ac.emi.ginfo.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ma.ac.emi.ginfo.backend.Services.ProductService;
import ma.ac.emi.ginfo.backend.entity.Product;
import ma.ac.emi.ginfo.backend.http.header.HeaderGenerator;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private HeaderGenerator headerGenerator;

    @PostMapping(value = "/products/")
    private ResponseEntity<Product> addProduct(@RequestBody Product product, HttpServletRequest request){
    	if(product != null) {
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
    	return new ResponseEntity<Product>(
    			headerGenerator.getHeadersForError(),
    			HttpStatus.BAD_REQUEST);       
    }
    
    @DeleteMapping(value = "/products/{id}")
    private ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
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
