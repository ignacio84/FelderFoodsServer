


/*INSERTA USUARIOS CON SUS ROLES*/
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

/*INSERTA MENU*/

/*MENU PRINCIPAL*/
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('VENTAS','MAIN', 'Ventas - Clientes', 'pricetags');
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('COMPRAS','MAIN', 'Compras - proveedores', 'cart' );
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('SOCIOS', 'MAIN','Socios De Negocios', 'people' );
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('BANCOS', 'MAIN','Gestión De Bancos', 'server' );
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('INVENTARIO', 'MAIN','Inventario', 'grid' );
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('PRODUCCION', 'MAIN','Producción', 'calculator' );


/*SUB MENU VENTAS*/
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA_ORDEN','VENTAS', 'Orden de venta', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA_ENTREGA','VENTAS', 'Entrega', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA_DEVOLUCION','VENTAS', 'Devolución', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA_FACTURA','VENTAS', 'Factura de deudores', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA_NOTA_CREDITO','VENTAS', 'Orden de venta', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA_INFORMES','VENTAS', 'Informes de ventas', 'browsers' );


/*SUB MENU VENTAS->INFORMES*/
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA_INFORMES_VENTA_ARTICULO','VENTA_INFORMES', 'Informe de ventas artículo', 'browsers' );

