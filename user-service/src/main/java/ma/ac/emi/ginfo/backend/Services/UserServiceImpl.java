package ma.ac.emi.ginfo.backend.Services;

import ma.ac.emi.ginfo.backend.entity.User;
import ma.ac.emi.ginfo.backend.entity.UserRole;
import ma.ac.emi.ginfo.backend.Repositories.UserRepository;
import ma.ac.emi.ginfo.backend.Repositories.UserRoleRepository;
import ma.ac.emi.ginfo.backend.models.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        user.setActive(1);
        return userRepository.save(user);
    }

    @Override
    public User login(UserLoginDTO user) {
        try{
            if(userRepository.findByEmailAndUserPassword(user.getEmail(), user.getPassword()).isPresent()) {
                return userRepository.findByEmailAndUserPassword(user.getEmail(), user.getPassword()).get();
            }
            else{
                throw new RuntimeException("user not found");
            }
        }catch(Exception e){
        }
        return null;
    }
}
