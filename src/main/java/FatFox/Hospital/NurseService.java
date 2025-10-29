package FatFox.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NurseService {
	@Autowired
	private NurseRepository nurseRepository;

	// CREATE
	public Nurse createNurse(Nurse nurse) {
		return nurseRepository.save(nurse);
	}

	// READ
	public Optional<Nurse> readNurse(Long id) {
		return nurseRepository.findById(id);
	}

	// DELETE
	public boolean deleteNurse(Long id) {
		if (nurseRepository.existsById(id)) {
			nurseRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Nurse searchByName(String name) {
		if (name == null || name.isEmpty()) {
			return null; // Returns null if name is null or empty
		}
		String lowerName = name.toLowerCase();
		Nurse nurse = nurseRepository.findByNameIgnoreCase(lowerName);
		return nurse; // Returns null if no match is found
	}

	public boolean login(String user, String password) {
		return nurseRepository.existsByUserAndPassword(user, password);
	}

	public Iterable<Nurse> getNurses() {
		return nurseRepository.findAll();
	}

}