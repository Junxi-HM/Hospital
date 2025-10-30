package FatFox.Hospital;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	// UPDATE
	public Nurse updateNurse(Long id, Nurse nurseData) {
		Optional<Nurse> existingNurse = nurseRepository.findById(id);

		if (existingNurse.isPresent()) {
			Nurse nurse = existingNurse.get();
			nurse.setName(nurseData.getName());
			nurse.setSurname(nurseData.getSurname());
			nurse.setUser(nurseData.getUser());
			nurse.setPassword(nurseData.getPassword());
			return nurseRepository.save(nurse);
		}
		return null;
	}

	// DELETE
	public boolean deleteNurse(Long id) {
		if (nurseRepository.existsById(id)) {
			nurseRepository.deleteById(id);
			return true;
		}
		return false;
	}

	// GET BY NAME
	public Nurse searchByName(String name) {
		if (name == null || name.isEmpty()) {
			return null; // Returns null if name is null or empty
		}
		String lowerName = name.toLowerCase();
		Nurse nurse = nurseRepository.findByNameIgnoreCase(lowerName);
		return nurse; // Returns null if no match is found
	}

	// LOGIN
	public boolean login(String user, String password) {
		return nurseRepository.existsByUserAndPassword(user, password);
	}

	// GET ALL
	public Iterable<Nurse> getNurses() {
		return nurseRepository.findAll();
	}

}