package ma.ac.emi.ginfo.backend.Services;
import java.util.List;

import ma.ac.emi.ginfo.backend.entity.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String userName);
    User saveUser(User user);
}
