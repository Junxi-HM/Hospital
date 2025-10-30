package FatFox.Hospital;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, Long> {
	Nurse findByNameIgnoreCase(String name);

	boolean existsByUserAndPassword(String user, String password);
}