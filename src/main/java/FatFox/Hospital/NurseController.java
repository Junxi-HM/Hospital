package FatFox.Hospital;

import java.util.Optional;

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

	// CREATE NURSE
	@PostMapping("/create")
	public ResponseEntity<Nurse> createNurse(@RequestBody Nurse nurse) {
		try {
			// Basic validation
			if (nurse.getName() == null || nurse.getName().isEmpty() || nurse.getSurname() == null
					|| nurse.getSurname().isEmpty() || nurse.getUser() == null || nurse.getUser().isEmpty()
					|| nurse.getPassword() == null || nurse.getPassword().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

			Nurse createdNurse = nurseService.createNurse(nurse);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdNurse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	// READ BY ID
	@GetMapping("/read/{id}")
	public ResponseEntity<Optional<Nurse>> findByID(@PathVariable Long id) {
		Optional<Nurse> nurse = nurseService.readNurse(id);
		if (nurse.isPresent()) {
			return ResponseEntity.ok(nurse);
		}
		return ResponseEntity.notFound().build();
	}

	// UPDATE BY ID
	@PutMapping("/update/{id}")
	public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @RequestBody Nurse nurse) {
		// Verify that the data submitted is correct
		if (nurse.getName() == null || nurse.getName().isEmpty() || nurse.getSurname() == null
				|| nurse.getSurname().isEmpty() || nurse.getUser() == null || nurse.getUser().isEmpty()
				|| nurse.getPassword() == null || nurse.getPassword().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nurse updatedNurse = nurseService.updateNurse(id, nurse);
		if (updatedNurse == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(updatedNurse);
	}

	// DELETE BY ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteNurse(@PathVariable Long id) {
		boolean deleted = nurseService.deleteNurse(id);
		if (!deleted) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().build();
	}

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