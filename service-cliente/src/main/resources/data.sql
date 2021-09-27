INSERT INTO tbl_typedocument (id, type) VALUES (1, 'Cedula Extrajera');
INSERT INTO tbl_typedocument (id, type) VALUES (2, 'Tarjeta Identidad');
INSERT INTO tbl_typedocument (id, type) VALUES (3, 'Cedula Ciudadania');

INSERT INTO tbl_customers (id, name, apellido, document, edad, ciudad, typedocument_id)
VALUES (1, 'Julian', 'Osorio', 1006316456, 17, 'AnsermaNuevo', 2);

INSERT INTO tbl_customers (id, name, apellido, document, edad, ciudad, typedocument_id)
VALUES (2, 'Pepito', 'Villegas', 1000248599, 24, 'CartagoValle', 3);

INSERT INTO tbl_customers (id, name, apellido, document, edad, ciudad, typedocument_id)
VALUES (3, 'gilmer', 'Botero', 812346989, 31, 'Argentina', 1);