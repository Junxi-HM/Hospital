package FatFox.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")  // from url starting with
public class NurseController {
	@Autowired
	private NurseService nurseService;

	@GetMapping("/name/{name}")
	public List<Nurse> searchNurses(@PathVariable String name) {
		return nurseService.searchByName(name);
	}

	/**
	 * @GetMapping("/nurse/login") public String login(@RequestParam Long
	 * id, @RequestParam String password) { Nurse nurse = nurseService.login(id,
	 * password); if (nurse != null) { return "Login succes, welcome! " +
	 * nurse.getName(); } else { return "Error, incorrect id or password!"; } }
	 **/

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		Nurse nurse = nurseService.login(loginRequest.getId(), loginRequest.getPassword());
		if (nurse != null) {
			return "Login succes, welcome! " + nurse.getName();
		} else {
			return "Error, incorrect id or password!";
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