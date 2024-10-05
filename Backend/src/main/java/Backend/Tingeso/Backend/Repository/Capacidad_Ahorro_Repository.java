package Backend.Tingeso.Backend.Repository;

import Backend.Tingeso.Backend.Entity.Capacidad_Ahorro_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Capacidad_Ahorro_Repository extends JpaRepository<Capacidad_Ahorro_Entity, Integer> {
}
