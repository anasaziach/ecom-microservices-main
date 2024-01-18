package ma.ac.emi.ginfo.backend.Controller;

import ma.ac.emi.ginfo.backend.entity.User;
import ma.ac.emi.ginfo.backend.http.header.HeaderGenerator;
import ma.ac.emi.ginfo.backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin("*")
public class RegisterController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private HeaderGenerator headerGenerator;
    
    @PostMapping(value = "/registration")
	@CrossOrigin("http://localhost:4200")
    public ResponseEntity<User> addUser(
		@RequestParam String userName,
		@RequestParam String email,
		@RequestParam String userPassword,
		@RequestParam int active,
		@RequestParam String role,
		HttpServletRequest request
		){
    	// if(user != null)
    		try {
				User user = new User(userName , email , userPassword , active , null,role);
    			userService.saveUser(user);
    			return new ResponseEntity<User>(
    					user,
    					headerGenerator.getHeadersForSuccessPostMethod(request, user.getId()),
    					HttpStatus.CREATED);
    		}catch (Exception e) {
    			e.printStackTrace();
    			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		// }
    	// return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			}
    }
}
