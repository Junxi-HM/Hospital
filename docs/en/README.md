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
To test all endpoints, import this JSON file into Postman: [Postman Collection](../../src/test/java/FatFox/Hospital/FatFox%20REST%20API%20basics-%20CRUD,%20test%20&%20variable.postman_collection.json)

---

### 👥 Authors
- [@Junxi-HM](https://github.com/Junxi-HM)
- [@Joan735](https://github.com/Joan735)
- [@kim-1111](https://github.com/kim-1111)

---

### ⚖️ License
This project has no specific license.