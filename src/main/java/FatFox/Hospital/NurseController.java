package FatFox.Hospital;

import FatFox.Hospital.Nurse;
import FatFox.Hospital.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/nurse") // from url starting with
public class NurseController {
	@Autowired
	private NurseService nurseService;

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Nurse>> searchNurses(@PathVariable String name) {
	    List<Nurse> nurses = nurseService.searchByName(name);
	    if (nurses.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(nurses);
	}

	/**
	 * @GetMapping("/nurse/login") public String login(@RequestParam Long
	 * id, @RequestParam String password) { Nurse nurse = nurseService.login(id,
	 * password); if (nurse != null) { return "Login succes, welcome! " +
	 * nurse.getName(); } else { return "Error, incorrect id or password!"; } }
	 **/

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody LoginRequest loginRequest) {
		boolean isAuthenticated = nurseService.login(loginRequest.getId(), loginRequest.getPassword());

		if (isAuthenticated) {
			return ResponseEntity.ok(true); // 200 OK
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false); // 401 Unauthorized
		}
	}

	public static class LoginRequest {
		private Long id;
		private String password;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

	@GetMapping("/index")
	public ResponseEntity<List<Nurse>> getAll() {
		return ResponseEntity.ok(nurseService.getNurses());
	}
}