package FatFox.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/nurse") // from url starting with
public class NurseController {
	@Autowired
	private NurseService nurseService;

	@GetMapping("/name/{name}")
	public ResponseEntity<Nurse> searchNurses(@PathVariable String name) {
	    Nurse nurse = nurseService.searchByName(name);
	    if (nurse == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(nurse);
	}

	@PostMapping("/login")
	 public ResponseEntity<Boolean> login(@RequestBody Nurse nurse) {
        boolean isAuthenticated = nurseService.login(nurse.getUser(), nurse.getPassword());
        
        if (isAuthenticated) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
    }
	
	@GetMapping("/index")
	public ResponseEntity<Iterable<Nurse>> getAll() {
		return ResponseEntity.ok(nurseService.getNurses());
	}
}