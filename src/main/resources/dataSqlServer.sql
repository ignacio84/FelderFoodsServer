



/**********************************************INSERTA EN TABLA catalogo_control********************************************************/
INSERT INTO catalogo_control 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt
                    ) 
VALUES            
                    (
                        'ROLE_ADMIN',
                        'Rol administrador del sistema.',
                        1,
                        -1,
                        '2021-07-19',
                        '2021-07-19'
                    );

INSERT INTO catalogo_control 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt
                    ) 
VALUES            
                    (
                        'ROLE_PROD',
                        'Rol para el area de producción, protege toda la ruta del modulo produccion.',
                        1,
                        -1,
                        '2021-07-19',
                        '2021-07-19'
                    );

INSERT INTO catalogo_control 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt
                    ) 
VALUES            
                    (
                        'ROLE_INSUMOS',
                        'Rol para el área de almacén de insumos, protege toda la ruta del modulo de insumos.',
                        1,
                        -1,
                        '2021-07-19',
                        '2021-07-19'
                    );

INSERT INTO catalogo_control 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt
                    ) 
VALUES            
                    (
                        'ROLE_MP_PT',
                        'Rol para el almacén de materia prima y pruducto terminado, protege toda la ruta del modulo de materia prima y pruducto terminado.',
                        1,
                        -1,
                        '2021-07-19',
                        '2021-07-19'
                    );


INSERT INTO catalogo_control 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt
                    ) 
VALUES            
                    (
                        'PROD_OF',
                        'Control en el modulo de produccion para procesar ordenes de fabricación.',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20'
                    );

INSERT INTO catalogo_control 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt  
                    ) 
VALUES            
                    (
                        'PROD_ALM',
                        'Control en el modulo de produccion para poder ver información de los almacenes.',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20'
                    );

INSERT INTO catalogo_control 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt 
                    ) 
VALUES            
                    (
                        'PROD_FIND_PRINT',
                        'Control en el modulo de produccion para poder buscar ordenes de fabricacion y reimprimir.',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20'
                    );


/******************************************INSERTA EN LA TABLA PERFIL perfil************************************************/
INSERT INTO perfil 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt  
                    ) 
VALUES            
                    (
                        'PRODUCCION',
                        'perfil para usuario de produccion.',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20'
                    );

INSERT INTO perfil 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt  
                    ) 
VALUES            
                    (
                        'ADMIN',
                        'Perfil para usuario administrador.',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20'
                    );

INSERT INTO perfil 
                    (   
                        nombre, 
                        descripcion, 
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt  
                    ) 
VALUES            
                    (
                        'ALMACEN_INSUMOS',
                        'Perfil para usuario de almacen de insumos.',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20'
                    );



/****************************************INSERTA EN LA TABLA PERFIL perfil_detalle********************************************/

INSERT INTO perfil_detalle
                    (   
                        nombre, 
                        descripcion, 
                        permiso,--N:no permitir, V:ver  S:si permitir todo
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt,  
                        perfil_id,
                        catalogo_control_id
                    ) 
VALUES            
                    (
                        'ADMIN',
                        'perfil rol administrador',
                        'N',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20',
                        1,
                        1
                    );
INSERT INTO perfil_detalle
                    (   
                        nombre, 
                        descripcion, 
                        permiso,--N:no permitir, V:ver  S:si permitir todo
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt,  
                        perfil_id,
                        catalogo_control_id
                    ) 
VALUES            
                    (
                        'PRODUCCION',
                        'perfil rol produccion.',
                        'S',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20',
                        1,
                        2
                    );
INSERT INTO perfil_detalle
                    (   
                        nombre, 
                        descripcion, 
                        permiso,--N:no permitir, V:ver  S:si permitir todo
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt,  
                        perfil_id,
                        catalogo_control_id
                    ) 
VALUES            
                    (
                        'PRODUCCION',
                        'perfil para usuario de produccion.',
                        'S',
                        0,
                        -1,
                        '2021-07-20',
                        '2021-07-20',
                        1,
                        2
                    );
INSERT INTO perfil_detalle
                    (   
                        nombre, 
                        descripcion, 
                        permiso,--N:no permitir, V:ver  S:si permitir todo
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt,  
                        perfil_id,
                        catalogo_control_id
                    ) 
VALUES            
                    (
                        'PRODUCCION',
                        'perfil para usuario de produccion.',
                        'V',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20',
                        1,
                        5
                    );
INSERT INTO perfil_detalle
                    (   
                        nombre, 
                        descripcion, 
                        permiso,--N:no permitir, V:ver  S:si permitir todo
                        enabled, 
                        idUsrAdd, 
                        addAt, 
                        upadateAt,  
                        perfil_id,
                        catalogo_control_id
                    ) 
VALUES            
                    (
                        'PRODUCCION',
                        'perfil para usuario de produccion.',
                        'N',
                        1,
                        -1,
                        '2021-07-20',
                        '2021-07-20',
                        1,
                        6
                    );




/****************************************INSERTA EN LA TABLA usuario********************************************/
INSERT INTO usuario
                    (   
                        username, 
                        password, 
                        enabled, 
                        nombre,
                        apellido, 
                        email, 
                        idUsrAdd,
                        addAt,
                        upadateAt,
                        perfil_id
                    ) 
VALUES            
                    (
                        'icastro*',
                        '$2a$10$.wMDFU0hzXk5aHCsfEPt9uVqOvqny51GgrOwg9pKo6k9d6Wh5Cv1S',
                        1,
                        'Ignacio',
                        'Castro',
                        'sistemas*@felderfoods.com',
                        -1,
                        '2021-07-20',
                        '2021-07-20',
                        1
                    );

INSERT INTO usuario
                    (   
                        username, 
                        password, 
                        enabled, 
                        nombre,
                        apellido, 
                        email, 
                        idUsrAdd,
                        addAt,
                        upadateAt,
                        perfil_id
                    ) 
VALUES            
                    (
                        'icastro',
                        '$2a$10$.wMDFU0hzXk5aHCsfEPt9uVqOvqny51GgrOwg9pKo6k9d6Wh5Cv1S',
                        1,
                        'Ignacio',
                        'Castro',
                        'sistemas@felderfoods.com',
                        -1,
                        '2021-07-20',
                        '2021-07-20',
                        2
                    );



-- 
-- -- INSERTA USUARIO
-- INSERT INTO usuarios (apellido, email, enabled, nombre, password, username  ) VALUES ('castro', 'ignacio.cm84@gmail.com', 1, 'Ignacio','$2a$10$1tX2JqfI37TtMDR4ketkruhGj6Z9S1o.ORzvszxziKn4iRilxwCxa', 'icastro');
-- INSERT INTO usuarios (apellido, email, enabled, nombre, password, username  ) VALUES ('Morales', 'produccion@felderfoods.com', 1, 'Lizeth','$2a$10$njvEFjEXP6.NOmsZOY4hTemsHPe9JBVuxgjOWrXAA7HQ4lYdAj/mu', 'lmorales');
-- INSERT INTO usuarios (apellido, email, enabled, nombre, password, username ) VALUES ('jesus', 'alsecos@felderfoods.com', 1, 'jesus','$2a$10$c9vGbfTRL2dj2iSGQigCB.f3Ajf1h7L5phUnYf/Nyv65AjzBky.i.', 'jesus');
-- INSERT INTO usuarios (apellido, email, enabled, nombre, password, username ) VALUES ('Zambrano', 'd.zambrano@felderfoods.com', 1, 'Daniel','$2a$10$c9vGbfTRL2dj2iSGQigCB.f3Ajf1h7L5phUnYf/Nyv65AjzBky.i.', 'dzambrano');
-- 
-- -- ASIGNA ROL A LOS USUARIO
-- INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('1', '1');
-- INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('2', '3');
-- INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('3', '5');
-- INSERT INTO usuarios_roles(usuario_id, role_id) VALUES ('4', '7');

