# examen

usar para crear en: http://localhost:8080/empleados

{
  "dni": "12345678",
  "nombre": "MARCELO",
  "apellidos": "DIAZ",
  "edad": 30,
  "salario": 3000.0,
  "fecha_contratacion": "2023-01-01",
  "estado": "ACTIVO"
}

usar para fecha de finalización en: http://localhost:8080/empleados/id
{
  "dni": "12345678",
  "nombre": "MARCELO",
  "apellidos": "DIAZ",
  "edad": 30,
  "salario": 3000.0,
  "fecha_contratacion": "2023-01-01",
 "fecha_finalizacion": "2023-05-04",
  "estado": "ACTIVO"
}

En serviceimpl en el mismo metodo de actualizar que usa putmapping se trabajo la actualizacion del estado al poner una fecha de finalización, no se trabajo como un endpoint independiente.


