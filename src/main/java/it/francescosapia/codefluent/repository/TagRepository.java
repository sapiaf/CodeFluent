package it.francescosapia.codefluent.repository;

import it.francescosapia.codefluent.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
