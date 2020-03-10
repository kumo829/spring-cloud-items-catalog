INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('andres', '$2a$10$ITzydHqGvVtZB5YTmlC0P.OfnlWHZK1GcDGq7.Yy1zgv4QLNYunXu', 1, 'Andres', 'Guzman', 'profesor@javatutoriales.com')
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$thAYFr3OLNbQwHHHdFVFOuGu/PXZ//1XGlQ2nfk2oiwXIH97wSuD6', 1, 'Admin', 'Sitio', 'admin@javatutoriales.com')

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, role_id) VALUES (1,1);
INSERT INTO usuarios_to_roles (user_id, role_id) VALUES (2,1);
INSERT INTO usuarios_to_roles (user_id, role_id) VALUES (2,2);