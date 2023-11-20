package it.francescosapia.codefluent.repository;

import it.francescosapia.codefluent.model.Role;
import it.francescosapia.codefluent.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
