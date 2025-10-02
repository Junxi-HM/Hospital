package FatFox.Hospital;

import FatFox.Hospital.Nurse;
import FatFox.Hospital.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NurseController {
    @Autowired
    private NurseService nurseService;

    @GetMapping("/nurses/search")
    public List<Nurse> searchNurses(@RequestParam String name) {
        return nurseService.searchByName(name);
    }
    
    @GetMapping("/nurses/login")
    public String login(@RequestParam Long id, @RequestParam String password) {
        Nurse nurse = nurseService.login(id, password);
        if (nurse != null) {
            return "Login succes, welcome!，" + nurse.getName();
        } else {
            return "Error, incorrect id or password!。";
        }
    }
}