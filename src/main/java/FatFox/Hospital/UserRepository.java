package FatFox.Hospital;
import org.springframework.data.repository.CrudRepository;
import FatFox.Hospital.Nurse;

public interface UserRepository extends CrudRepository<Nurse, Long> {

	boolean existsByUserAndPassword(String user, String password);  
}