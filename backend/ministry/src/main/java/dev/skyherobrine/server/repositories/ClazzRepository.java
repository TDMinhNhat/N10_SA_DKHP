package dev.skyherobrine.server.repositories;

import dev.skyherobrine.server.models.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz,String> {
}
