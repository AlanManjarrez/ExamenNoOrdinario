DELIMITER //
CREATE PROCEDURE agregar_chat(
	IN p_nombre_usuario VARCHAR(255),
    OUT p_id_chat INT
)
BEGIN
	INSERT INTO CHATS(NOMBRE_USUARIO)
    VALUES(p_nombre_usuario);
    
    SET p_id_chat = LAST_INSERT_ID();
END //
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE editar_chat(
	IN p_id_chat INT,
	IN p_nombre_usuario VARCHAR(255)
)
BEGIN
	UPDATE CHATS
    SET
		NOMBRE_USUARIO = p_nombre_usuario
	WHERE 
		ID_CHAT = p_id_chat;
END $$
DELIMITER ;

DELIMITER ++
CREATE PROCEDURE eliminar_chat(
	IN p_id_chat INT
)
BEGIN
	DELETE FROM MENSAJES 
    WHERE ID_CHAT = p_id_chat;
    
    DELETE FROM PARTICIPANTES
    WHERE ID_CHAT = p_id_chat;
    
    DELETE FROM CHATS
    WHERE ID_CHAT = p_id_chat;
END ++
DELIMITER ;

DELIMITER %%
CREATE PROCEDURE consultar_chat(
	IN p_id_chat INT
)
BEGIN
	SELECT
		C.ID_CHAT,
		C.NOMBRE_USUARIO
	FROM 
		CHATS C
	WHERE 
		ID_CHAT = p_id_chat;
END %%
DELIMITER ;
		
	