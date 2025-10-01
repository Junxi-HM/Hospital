package FatFox.Hospital;
import FatFox.Hospital.Nurse;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NurseService {
    private List<Nurse> nurses = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Sample data initialization
        nurses.add(new Nurse(1L, "Alice Johnson"));
        nurses.add(new Nurse(2L, "Bob Smith"));
        nurses.add(new Nurse(3L, "Carol Davis"));
        nurses.add(new Nurse(4L, "David Alice")); // For partial match testing
    }

    public List<Nurse> searchByName(String name) {
        if (name == null || name.isEmpty()) {
            return new ArrayList<>(); // Or return all if preferred
        }
        String lowerName = name.toLowerCase();
        return nurses.stream()
                .filter(nurse -> nurse.getName().toLowerCase().contains(lowerName))
                .collect(Collectors.toList());
    }
}