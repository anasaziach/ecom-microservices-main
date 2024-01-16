package ma.ac.emi.ginfo.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.emi.ginfo.backend.entity.UserRole;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findUserRoleByRoleName(String roleName);
}