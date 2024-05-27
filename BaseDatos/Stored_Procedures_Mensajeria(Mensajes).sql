DELIMITER //
CREATE PROCEDURE agregar_mensaje(
	IN p_texto VARCHAR(500),
    IN p_fecha_hora_registro DATETIME,
    IN p_imagen_mensaje LONGBLOB,
    IN p_id_usuario INT,
    IN p_id_chat INT
)
BEGIN
	INSERT INTO MENSAJES(TEXTO, FECHA_HORA_REGISTRO, IMAGEN_MENSAJE, ID_USUARIO, ID_CHAT)
    VALUES (p_texto, p_fecha_hora_registro, p_imagen_mensaje, p_id_usuario, p_id_chat);
END //
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE editar_mensaje(
	IN p_id_mensaje INT,
    IN p_texto VARCHAR(500)
)
BEGIN
	UPDATE MENSAJES
    SET
		TEXTO = p_texto
	WHERE
		ID_MENSAJE = p_id_mensaje;
END $$
DELIMITER ;

DELIMITER ++
CREATE PROCEDURE eliminar_mensaje(
	IN p_id_mensaje INT
)
BEGIN
	DELETE FROM MENSAJES
    WHERE ID_MENSAJE = p_id_mensaje;
END ++
DELIMITER ;

DELIMITER %%
CREATE PROCEDURE consultar_mensaje(
	IN p_texto VARCHAR(500)
)
BEGIN
	SELECT
		M.ID_MENSAJE,
		M.TEXTO,
        M.FECHA_HORA_REGISTRO,
        M.IMAGEN_MENSAJE
	FROM
		MENSAJES M 
	WHERE
		 M.TEXTO LIKE CONCAT('%', p_texto, '%');
END %%
DELIMITER ;
        