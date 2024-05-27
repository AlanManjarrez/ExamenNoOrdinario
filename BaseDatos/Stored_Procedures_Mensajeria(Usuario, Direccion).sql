DELIMITER $$
CREATE PROCEDURE agregar_usuario(
	IN p_telefono VARCHAR(10),
    IN p_contrasena VARCHAR(16),
    IN p_sexo VARCHAR(50),
    IN p_fecha_nacimiento DATE,
    IN p_imagen_perfil LONGBLOB
)
BEGIN
	INSERT INTO USUARIOS(TELEFONO, CONTRASENA, SEXO, FECHA_NACIMIENTO, IMAGEN_PERFIL)
    VALUES(p_telefono, p_contrasena, p_sexo, p_fecha_nacimiento, p_imagen_perfil);
END $$
DELIMITER ;

DELIMITER //
CREATE PROCEDURE agregar_direccion(
	IN p_calle VARCHAR(255),
    IN p_numero VARCHAR(50),
    IN p_codigo_postal VARCHAR(10),
    IN p_id_usuario INT
)
BEGIN
	INSERT INTO DIRECCIONES(CALLE, NUMERO, CODIGO_POSTAL, ID_USUARIO)
    VALUES(p_calle, p_numero, p_codigo_postal, p_id_usuario);
END //
DELIMITER ;

DELIMITER !!
CREATE PROCEDURE consultar_usuario_telefono_contrasena(
	IN p_telefono VARCHAR(10),
    IN p_contrasena VARCHAR(16)
)
BEGIN
	SELECT 
		U.ID_USUARIO,
		U.TELEFONO,
        U.CONTRASENA, 
        U.SEXO,
        U.FECHA_NACIMIENTO,
        U.IMAGEN_PERFIL
	FROM
		USUARIOS U
	WHERE 
		U.TELEFONO = p_telefono AND U.CONTRASENA = p_contrasena;
END !!
DELIMITER ;

DELIMITER ))
CREATE PROCEDURE consultar_usuario_telefono(
	IN p_telefono VARCHAR(10)
)
BEGIN
	SELECT 
		U.ID_USUARIO,
		U.TELEFONO,
        U.CONTRASENA, 
        U.SEXO,
        U.FECHA_NACIMIENTO,
        U.IMAGEN_PERFIL
	FROM
		USUARIOS U
	WHERE 
		U.TELEFONO LIKE CONCAT('%', p_telefono, '%');
END ))
DELIMITER ;

DELIMITER !!
CREATE PROCEDURE consultar_direccion(
	IN p_id_usuario INT
)
BEGIN
	SELECT 
		D.CALLE,
        D.NUMERO,
        D.CODIGO_POSTAL
	FROM
		DIRECCIONES D
	WHERE 
		D.ID_USUARIO = p_id_usuario;
END !!
DELIMITER ;

DELIMITER ++
CREATE PROCEDURE actualizar_usuario(
	IN p_id_usuario INT,
	IN p_telefono VARCHAR(10),
    IN p_contrasena VARCHAR(16),
    IN p_sexo VARCHAR(50),
    IN p_fecha_nacimiento DATE,
    IN p_imagen_perfil LONGBLOB
)
BEGIN
	UPDATE USUARIOS
    SET
		TELEFONO = p_telefono,
        CONTRASENA = p_contrasena,
        SEXO = p_sexo,
        FECHA_NACIMIENTO = p_fecha_nacimiento,
        IMAGEN_PERFIL = p_imagen_perfil
	WHERE
		ID_USUARIO = p_id_usuario;
END ++
DELIMITER ;

DELIMITER °°
CREATE PROCEDURE actualizar_direccion(
    IN p_calle VARCHAR(255),
    IN p_numero VARCHAR(50),
    IN p_codigo_postal VARCHAR(10),
    IN p_id_usuario INT
)
BEGIN
	UPDATE DIRECCIONES
    SET
		CALLE = p_calle,
        NUMERO = p_numero,
        CODIGO_POSTAL = p_codigo_postal
	WHERE 
		ID_USUARIO = p_id_usuario;
END °°
DELIMITER ;
