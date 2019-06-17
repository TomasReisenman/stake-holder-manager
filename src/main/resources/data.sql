/*
INSERT INTO titular_fisico (cuit, nombre, apellido ,dni, creation_timestamp, modification_timestamp, version_number)
VALUES ('60795','Juan' ,'Perez', '234959', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO titular_juridico (cuit, razon_social, foundation_year , creation_timestamp, modification_timestamp, version_number)
VALUES ('997543','industrial' ,'1998',  CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

*/

INSERT INTO titular (id, cuit, creation_timestamp, modification_timestamp, version_number)
VALUES (1,'24552', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO titular_fisico (nombre, apellido ,dni,id)
VALUES ('Juan' ,'Perez', '234959',1);

INSERT INTO titular (id, cuit, creation_timestamp, modification_timestamp, version_number)
VALUES (2,'74564', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO titular_juridico (razon_social, foundation_year,id)
VALUES ('industrial' ,'1998',2);


/*INSERT INTO titular (iso_code, name, creation_timestamp, modification_timestamp, version_number)
VALUES ('BR','BRASIL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO titular (iso_code, name, creation_timestamp, modification_timestamp, version_number)
VALUES ('UY','URUGUAY', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO titular (iso_code, name, creation_timestamp, modification_timestamp, version_number)
VALUES ('CH','CHILE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);*/
