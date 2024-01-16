package ma.ac.emi.ginfo.backend.Services;
import java.util.List;

import ma.ac.emi.ginfo.backend.entity.User;
import ma.ac.emi.ginfo.backend.models.UserLoginDTO;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String userName);
    User saveUser(User user);
    User login(UserLoginDTO user);
}
