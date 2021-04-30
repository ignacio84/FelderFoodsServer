


/*INSERTA USUARIOS CON SUS ROLES*/
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_MATERIA');
INSERT INTO roles (nombre) VALUES ('ROLE_VENTAS_1');

INSERT INTO usuarios (apellido, email, enabled, nombre, password, username  ) VALUES ('castro', 'ignacio.cm84@gmail.com', 1, 'Ignacio','$2a$10$1tX2JqfI37TtMDR4ketkruhGj6Z9S1o.ORzvszxziKn4iRilxwCxa', 'icastro');
INSERT INTO usuarios (apellido, email, enabled, nombre, password, username  ) VALUES ('Rodriguez', 'mr@gmail.com', 1, 'Marco','$2a$10$njvEFjEXP6.NOmsZOY4hTemsHPe9JBVuxgjOWrXAA7HQ4lYdAj/mu', 'mrodriguez');
INSERT INTO usuarios (apellido, email, enabled, nombre, password, username ) VALUES ('prueba', 'prueba@gmail.com', 1, 'Marco','$2a$10$c9vGbfTRL2dj2iSGQigCB.f3Ajf1h7L5phUnYf/Nyv65AjzBky.i.', 'prueba');
INSERT INTO usuarios (apellido, email, enabled, nombre, password, username ) VALUES ('Campos', 'ventas@gmail.com', 1, 'Juan','$2a$10$c9vGbfTRL2dj2iSGQigCB.f3Ajf1h7L5phUnYf/Nyv65AjzBky.i.', 'ventas');

INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('1', '2');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('1', '1');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('2', '1');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('3', '2');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('3', '3');
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('4', '4');


/*INSERTA MENU*/

/*MENU PRINCIPAL*/
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('VENTAS','MAIN', 'Ventas - Clientes', 'pricetags');
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('COMPRAS','MAIN', 'Compras - proveedores', 'cart' );
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('SOCIOS', 'MAIN','Socios De Negocios', 'people' );
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('INVENTARIO', 'MAIN','Inventario', 'grid' );
INSERT INTO menu ( clave, clavePadre ,nombre, icono  ) VALUES ('PRODUCCION', 'MAIN','Producción', 'calculator' );


/*SUB MENU VENTAS*/
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA-ORDEN','VENTAS', 'Orden de venta', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA-ENTREGA','VENTAS', 'Entrega', 'albums' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA-DEVOLUCION','VENTAS', 'Devolución', 'refresh-circle' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA-FACTURA','VENTAS', 'Factura de deudores', 'document-text' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA-NOTA-CREDITO','VENTAS', 'Nota de crédito de clientes', 'documents' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA-INFORMES','VENTAS', 'Informes de ventas', 'bar-chart' );

/*SUB MENU COMPRAS*/
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('COMPRAS-ORDEN','COMPRAS', 'Pedido', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('COMPRAS-ENTRADA','COMPRAS', 'Entrada de mercancías', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('COMPRAS-DEVOLUCION','COMPRAS', 'Devolución de mercancías', 'browsers' );
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('COMPRAS-FACTURA-PROVEEDOR','COMPRAS', 'Factura de proveedores', 'browsers' );


/*SUB MENU INVENTARIO*/
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('INVENTARIO-MAESTRO-ARTICULO','INVENTARIO', 'Datos maestro de artículo', 'document-text' );


/*SUB MENU VENTAS->INFORMES*/
INSERT INTO menu ( clave, clavePadre, nombre, icono) VALUES ('VENTA-INFORMES-VENTA-ARTICULO','VENTA-INFORMES', 'Informe de ventas artículo', 'browsers' );



/*INSERTA LOS MENU A LOS QUE TENDRA ACCESO LOS ROLES ( MENU PRINCIPAL ) */
INSERT INTO role_permiso ( clave, clavePadre ,nombre, icono , role ) VALUES ('VENTAS','MAIN', 'Ventas - Clientes', 'pricetags','ROLE_VENTAS_1');
INSERT INTO role_permiso ( clave, clavePadre ,nombre, icono , role ) VALUES ('COMPRAS','MAIN', 'Compras - proveedores', 'cart','ROLE_VENTAS_1' );
INSERT INTO role_permiso ( clave, clavePadre ,nombre, icono , role ) VALUES ('SOCIOS', 'MAIN','Socios De Negocios', 'people' ,'ROLE_VENTAS_1');
INSERT INTO role_permiso ( clave, clavePadre ,nombre, icono , role ) VALUES ('INVENTARIO', 'MAIN','Inventario', 'grid' ,'ROLE_VENTAS_1');
INSERT INTO role_permiso ( clave, clavePadre ,nombre, icono , role ) VALUES ('PRODUCCION', 'MAIN','Producción', 'calculator' ,'ROLE_VENTAS_1');

/*SUBMENU DE INVENTARIOS*/
INSERT INTO role_permiso ( clave, clavePadre ,nombre, icono , role ) VALUES ('INVENTARIO-MAESTRO-ARTICULO', 'INVENTARIO','Datos maestro de artículo', 'document-text' ,'ROLE_VENTAS_1');
