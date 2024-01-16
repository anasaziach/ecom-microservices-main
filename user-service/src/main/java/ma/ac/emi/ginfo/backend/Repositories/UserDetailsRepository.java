package ma.ac.emi.ginfo.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.emi.ginfo.backend.entity.UserDetails;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
