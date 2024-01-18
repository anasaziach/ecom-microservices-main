package ma.ac.emi.ginfo.backend.Controller;

import ma.ac.emi.ginfo.backend.entity.User;
import ma.ac.emi.ginfo.backend.http.header.HeaderGenerator;
import ma.ac.emi.ginfo.backend.Services.*;
import ma.ac.emi.ginfo.backend.models.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private HeaderGenerator headerGenerator;
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<User> login(@PathVariable String email , @PathVariable String password , HttpServletRequest request){
		UserLoginDTO user = new UserLoginDTO(email , password);
		User userr = this.userService.login(user);
		if(userr != null)
			try {
				HttpHeaders headers = headerGenerator.getHeadersForSuccessPostMethod(request, userr.getId());
				return new ResponseEntity<>(userr, headers, HttpStatus.OK);
			}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/login/test")
	public String test(){
		return "test";
	}
    
    @GetMapping (value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userService.getAllUsers();
        if(!users.isEmpty()) {
        	return new ResponseEntity<List<User>>(
        		users,
        		headerGenerator.getHeadersForSuccessGetMethod(),
        		HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/users", params = "name")
    public ResponseEntity<User> getUserByName(@RequestParam("name") String userName){
    	User user = userService.getUserByName(userName);
    	if(user != null) {
    		return new ResponseEntity<User>(
    				user,
    				headerGenerator.
    				getHeadersForSuccessGetMethod(),
    				HttpStatus.OK);
    	}
        return new ResponseEntity<User>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(user != null) {
    		return new ResponseEntity<User>(
    				user,
    				headerGenerator.
    				getHeadersForSuccessGetMethod(),
    				HttpStatus.OK);
    	}
        return new ResponseEntity<User>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }

    @PostMapping (value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).body(
			userService.saveUser(user)
		);
    }
}
