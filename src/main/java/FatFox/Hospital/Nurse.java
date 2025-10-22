package FatFox.Hospital;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity                      // Marca esta clase como una entidad JPA
public class Nurse {

    @Id                                          // Indica la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    private String name;
    private String password;

    public Nurse() {
        super();
    }

    public Nurse(Long id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Nurse(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
