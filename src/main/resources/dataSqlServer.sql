
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_MATERIA');

INSERT INTO usuarios (apellido, email, enabled, nombre, password, username  ) VALUES ('castro', 'ignacio.cm84@gmail.com', 1, 'Ignacio','$2a$10$1tX2JqfI37TtMDR4ketkruhGj6Z9S1o.ORzvszxziKn4iRilxwCxa', 'icastro');
INSERT INTO usuarios (apellido, email, enabled, nombre, password, username  ) VALUES ('Rodriguez', 'mr@gmail.com', 1, 'Marco','$2a$10$njvEFjEXP6.NOmsZOY4hTemsHPe9JBVuxgjOWrXAA7HQ4lYdAj/mu', 'mrodriguez');
INSERT INTO usuarios (apellido, email, enabled, nombre, password, username ) VALUES ('prueba', 'prueba@gmail.com', 1, 'Marco','$2a$10$c9vGbfTRL2dj2iSGQigCB.f3Ajf1h7L5phUnYf/Nyv65AjzBky.i.', 'prueba');

INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('1', '2');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('1', '1');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('2', '1');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('3', '2');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('3', '3');

