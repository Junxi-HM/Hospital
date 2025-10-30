# 🏥 Hospital

## 🌍 English

### 📖 Description
The **Hospital** project aims to create an application for **managing patient medical records** and **nurse staff data**. The system allows users to register, retrieve, update, and delete both patient and nurse information easily. It provides a user-friendly interface that includes all relevant patient data.

### ⚙️ Technologies Used
- Language: **Java**
- Framework: **Spring Boot**
- IDEs: **Eclipse** / **Oracle NetBeans**

---

### 🧩 Installation

#### 🔹 Clone the repository
Clone the project from GitHub:

```bash
https://github.com/Junxi-HM/Hospital
```

#### 🔹 In Eclipse
1. Open **Eclipse**.
2. Go to `File > Import > Git > Projects from Git (with smart import)`.
3. Select **Clone URI**.
4. Paste the URL above and provide your **GitHub username** and **personal access token**.
5. Finish the process to import the project.

#### 🔹 In Oracle NetBeans
1. Open **NetBeans**.
2. Go to `Team > Git > Clone`.
3. Paste the repository URL and enter your credentials.
4. Click **Next**, then **Finish**.

> 💡 No additional dependencies or environment configuration are required.

---

### ▶️ Usage

To run the application:
1. Open the project in your IDE.
2. Run the file:

```
HospitalApplication.java
```

3. Use **Postman** to test the API endpoints. The base URL is:
```
http://localhost:8080/nurse
```

#### 🔹 Available Endpoints (NurseController)
| Method | Path | Description |
|--------|------|-------------|
| POST | `/new` | Create a new nurse |
| GET | `/{id}` | Find nurse by ID |
| PUT | `/{id}` | Update nurse by ID |
| DELETE | `/{id}` | Delete nurse by ID |
| GET | `/name/{name}` | Find nurse by name |
| POST | `/login` | Nurse login |
| GET | `/index` | Get all nurses |

#### 🔹 Postman Collection
You can test all endpoints using this Postman collection: [Postman Collection](https://joanye777-7222981.postman.co/workspace/Joan-Ye's-Workspace~8a2b14e3-3b6f-47fc-8435-b5eb179aec2e/collection/48943275-c22ef72d-da7d-4595-b85e-e6d17837ad3d?action=share&creator=48943275)

---

### 👥 Authors
- [@Junxi-HM](https://github.com/Junxi-HM)
- [@Joan735](https://github.com/Joan735)
- [@kim-1111](https://github.com/kim-1111)

---

### ⚖️ License
This project has no specific license.