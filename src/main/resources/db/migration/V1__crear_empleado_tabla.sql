CREATE TABLE empleado (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          dni VARCHAR(10) NOT NULL,
                          nombres VARCHAR(50) NOT NULL,
                          apellidos VARCHAR(50) NOT NULL,
                          edad INT NOT NULL,
                          salario DECIMAL(10, 2) NOT NULL,
                          fecha_contratacion DATE NOT NULL,
                          fecha_finalizacion DATE,
                          stado VARCHAR(20) NOT NULL,
                          eliminacion_logica BOOLEAN NOT NULL DEFAULT FALSE
);