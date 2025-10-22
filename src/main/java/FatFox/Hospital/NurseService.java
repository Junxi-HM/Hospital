package FatFox.Hospital;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NurseService {
	private List<Nurse> nurses = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
	
	@PostConstruct
	public void init() {
		try {
            // Path to the JSON file
            File file = new File("src/main/java/FatFox/Hospital/NurseData.json");
            // Read JSON file and map it to a List<Nurse>
            nurses = objectMapper.readValue(file, new TypeReference<List<Nurse>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log error, throw custom exception, or initialize with empty list)
            nurses = new ArrayList<>();
        }
	}


	@Autowired
    private NurseRepository nurseRepository;
    public Nurse searchByName(String name) {
        if (name == null || name.isEmpty()) {
            return null; // Returns null if name is null or empty
        }
        String lowerName = name.toLowerCase();
        Optional<Nurse> nurse = nurseRepository.findByNameIgnoreCase(lowerName);
        return nurse.orElse(null); // Returns null if no match is found
    }

	public boolean login(Long id, String password) {
		return nurses.stream().anyMatch(nurse -> nurse.getId().equals(id) && nurse.getPassword().equals(password));
	}

	public List<Nurse> getNurses() {
		return nurses;
	}
}