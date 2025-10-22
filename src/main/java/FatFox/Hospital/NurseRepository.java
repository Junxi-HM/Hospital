package FatFox.Hospital;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, Long>{
    Optional<Nurse> findByNameIgnoreCase(String name);
    boolean existsByUserAndPassword(String user, String password);  
}