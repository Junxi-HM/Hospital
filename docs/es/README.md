# 🏥 Hospital

## 🌍 Español

### 📖 Descripción
El proyecto **Hospital** tiene como objetivo desarrollar una aplicación para la **gestión de datos clínicos de pacientes** y la **administración del personal de enfermería**. El sistema permite registrar, consultar, actualizar y eliminar información de pacientes y enfermeros de manera ordenada y sencilla. Proporciona una interfaz fácil de usar que incluye todos los datos relevantes del paciente.

### ⚙️ Tecnologías utilizadas
- Lenguaje: **Java**
- Framework: **Spring Boot**
- IDEs: **Eclipse** / **Oracle NetBeans**

---

### 🧩 Instalación

#### 🔹 Clonar el repositorio
Clona el proyecto desde GitHub:

```bash
https://github.com/Junxi-HM/Hospital
```

#### 🔹 En Eclipse
1. Abre **Eclipse**.
2. Ve a `File > Import > Git > Projects from Git (with smart import)`.
3. Selecciona **Clone URI**.
4. Pega la URL arriba y proporciona tu **usuario de GitHub** y **token personal**.
5. Finaliza el proceso para importar el proyecto.

#### 🔹 En Oracle NetBeans
1. Abre **NetBeans**.
2. Ve a `Team > Git > Clone`.
3. Pega la URL del repositorio e ingresa tus credenciales.
4. Haz clic en **Next** y luego en **Finish**.

> 💡 No se requieren dependencias adicionales ni configuración de entorno.

---

### ▶️ Uso

Para ejecutar la aplicación:
1. Abre el proyecto en tu IDE.
2. Ejecuta el archivo:

```
HospitalApplication.java
```

3. Usa **Postman** para probar los siguientes endpoints de la API. La URL base es:
```
http://localhost:8080/nurse
```

#### 🔹 Endpoints disponibles (NurseController)
| Método | Ruta | Descripción |
|--------|------|-------------|
| POST | `/new` | Crear un nuevo enfermero |
| GET | `/{id}` | Buscar enfermero por ID |
| PUT | `/{id}` | Actualizar enfermero por ID |
| DELETE | `/{id}` | Eliminar enfermero por ID |
| GET | `/name/{name}` | Buscar enfermero por nombre |
| POST | `/login` | Inicio de sesión del enfermero |
| GET | `/index` | Obtener todos los enfermeros |

#### 🔹 Enlace de Postman
Puedes probar todos los endpoints usando esta colección de Postman: [Postman Collection](https://joanye777-7222981.postman.co/workspace/Joan-Ye's-Workspace~8a2b14e3-3b6f-47fc-8435-b5eb179aec2e/collection/48943275-c22ef72d-da7d-4595-b85e-e6d17837ad3d?action=share&creator=48943275)

---

### 👥 Autores
- [@Junxi-HM](https://github.com/Junxi-HM)
- [@Joan735](https://github.com/Joan735)
- [@kim-1111](https://github.com/kim-1111)

---

### ⚖️ Licencia
Este proyecto no tiene licencia específica.