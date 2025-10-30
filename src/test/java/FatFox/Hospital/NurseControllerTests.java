package FatFox.Hospital;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NurseController.class)
class NurseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private NurseService nurseService;

    private Nurse testNurse;

    @BeforeEach
    void setUp() {
        testNurse = new Nurse();
        testNurse.setId(1L);
        testNurse.setName("Maria");
        testNurse.setSurname("Garcia");
        testNurse.setUser("mgarcia");
        testNurse.setPassword("password123");
    }

    // TEST CREATE NURSE - SUCCESS
    @Test
    void createNurse_Success() throws Exception {
        when(nurseService.createNurse(any(Nurse.class))).thenReturn(testNurse);

        mockMvc.perform(post("/nurse/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testNurse)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Maria"))
                .andExpect(jsonPath("$.surname").value("Garcia"));
    }

    // TEST CREATE NURSE - BAD REQUEST (empty name)
    @Test
    void createNurse_BadRequest_EmptyName() throws Exception {
        Nurse invalidNurse = new Nurse();
        invalidNurse.setName("");
        invalidNurse.setSurname("Garcia");
        invalidNurse.setUser("mgarcia");
        invalidNurse.setPassword("password123");

        mockMvc.perform(post("/nurse/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidNurse)))
                .andExpect(status().isBadRequest());
    }

    // TEST CREATE NURSE - BAD REQUEST (null fields)
    @Test
    void createNurse_BadRequest_NullFields() throws Exception {
        Nurse invalidNurse = new Nurse();
        invalidNurse.setName("Maria");

        mockMvc.perform(post("/nurse/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidNurse)))
                .andExpect(status().isBadRequest());
    }

    // TEST READ BY ID - SUCCESS
    @Test
    void findByID_Success() throws Exception {
        when(nurseService.readNurse(1L)).thenReturn(Optional.of(testNurse));

        mockMvc.perform(get("/nurse/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Maria"));
    }

    // TEST READ BY ID - NOT FOUND
    @Test
    void findByID_NotFound() throws Exception {
        when(nurseService.readNurse(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/nurse/999"))
                .andExpect(status().isNotFound());
    }

    // TEST UPDATE - SUCCESS
    @Test
    void updateNurse_Success() throws Exception {
        Nurse updatedNurse = new Nurse();
        updatedNurse.setId(1L);
        updatedNurse.setName("Maria");
        updatedNurse.setSurname("Lopez");
        updatedNurse.setUser("mlopez");
        updatedNurse.setPassword("newpassword");

        when(nurseService.updateNurse(eq(1L), any(Nurse.class))).thenReturn(updatedNurse);

        mockMvc.perform(put("/nurse/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedNurse)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surname").value("Lopez"));
    }

    // TEST UPDATE - NOT FOUND
    @Test
    void updateNurse_NotFound() throws Exception {
        when(nurseService.updateNurse(eq(999L), any(Nurse.class))).thenReturn(null);

        mockMvc.perform(put("/nurse/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testNurse)))
                .andExpect(status().isNotFound());
    }

    // TEST UPDATE - BAD REQUEST
    @Test
    void updateNurse_BadRequest() throws Exception {
        Nurse invalidNurse = new Nurse();
        invalidNurse.setName("");

        mockMvc.perform(put("/nurse/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidNurse)))
                .andExpect(status().isBadRequest());
    }

    // TEST DELETE - SUCCESS
    @Test
    void deleteNurse_Success() throws Exception {
        when(nurseService.deleteNurse(1L)).thenReturn(true);

        mockMvc.perform(delete("/nurse/1"))
                .andExpect(status().isOk());
    }

    // TEST DELETE - NOT FOUND
    @Test
    void deleteNurse_NotFound() throws Exception {
        when(nurseService.deleteNurse(999L)).thenReturn(false);

        mockMvc.perform(delete("/nurse/999"))
                .andExpect(status().isNotFound());
    }

    // TEST SEARCH BY NAME - SUCCESS
    @Test
    void searchNurses_Success() throws Exception {
        when(nurseService.searchByName("Maria")).thenReturn(testNurse);

        mockMvc.perform(get("/nurse/name/Maria"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Maria"));
    }

    // TEST SEARCH BY NAME - NOT FOUND
    @Test
    void searchNurses_NotFound() throws Exception {
        when(nurseService.searchByName("Unknown")).thenReturn(null);

        mockMvc.perform(get("/nurse/name/Unknown"))
                .andExpect(status().isNotFound());
    }

    // TEST LOGIN - SUCCESS
    @Test
    void login_Success() throws Exception {
        when(nurseService.login("mgarcia", "password123")).thenReturn(true);

        Nurse loginNurse = new Nurse();
        loginNurse.setUser("mgarcia");
        loginNurse.setPassword("password123");

        mockMvc.perform(post("/nurse/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginNurse)))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    // TEST LOGIN - UNAUTHORIZED
    @Test
    void login_Unauthorized() throws Exception {
        when(nurseService.login("mgarcia", "wrongpassword")).thenReturn(false);

        Nurse loginNurse = new Nurse();
        loginNurse.setUser("mgarcia");
        loginNurse.setPassword("wrongpassword");

        mockMvc.perform(post("/nurse/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginNurse)))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("false"));
    }

    // TEST GET ALL - SUCCESS
    @Test
    void getAll_Success() throws Exception {
        Nurse nurse2 = new Nurse();
        nurse2.setId(2L);
        nurse2.setName("Juan");
        nurse2.setSurname("Perez");
        nurse2.setUser("jperez");
        nurse2.setPassword("pass456");

        when(nurseService.getNurses()).thenReturn(Arrays.asList(testNurse, nurse2));

        mockMvc.perform(get("/nurse/index"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Maria"))
                .andExpect(jsonPath("$[1].name").value("Juan"));
    }
}