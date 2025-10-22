**README – ApiTransaccion_bibliotec**

## Tecnologías utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Lombok**
- **Maven**
- **Swagger / OpenAPI 3**
- **Spring Cloud** *(si forma parte de arquitectura de microservicios)*

---

## Funcionalidades principales

- Registrar una transacción (préstamo o devolución)  
- Consultar transacciones por usuario o por libro  
- Actualizar el estado de una transacción  
- Eliminar o marcar como inactiva una transacción  
- Generar reportes de actividad (por rango de fechas o tipo de transacción)

---
## Endpoints principales

| Método | Endpoint | Descripción |
|--------|-----------|-------------|
| GET | `/api/transacciones/{id}` | Consulta una transacción por ID |
| POST | `/api/transacciones` | Registra una nueva transacción |
| PUT | `/api/transacciones/{id}` | Actualiza una transacción |
| DELETE | `/api/transacciones/{id}` | Elimina (o marca como inactiva) una transacción |

---
git clone https://github.com/Jeanferx/ApiTransaccion_biblioteca.git
