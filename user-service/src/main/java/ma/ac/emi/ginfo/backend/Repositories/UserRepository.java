package ma.ac.emi.ginfo.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.emi.ginfo.backend.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}