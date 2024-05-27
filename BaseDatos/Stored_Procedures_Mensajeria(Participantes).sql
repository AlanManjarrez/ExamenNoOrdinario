DELIMITER //
CREATE PROCEDURE agregar_participante(
	IN p_id_usuario INT,
    IN p_id_chat INT
)
BEGIN
	INSERT INTO PARTICIPANTES(ID_USUARIO, ID_CHAT)
    VALUES(p_id_usuario, p_id_chat);
END //
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE actualizar_participante(
	IN p_id_participante INT,
    IN p_id_usuario INT,
    IN p_id_chat INT
)
BEGIN
	UPDATE PARTICIPANTES
    SET
		ID_USUARIO = p_id_usuario,
        ID_CHAT = p_id_chat
	WHERE 
		ID_PARTICIPANTE = p_id_participante;
END $$
DELIMITER ;

DELIMITER ++
CREATE PROCEDURE eliminar_participante(
    IN p_id_participante INT
)
BEGIN
    DELETE FROM PARTICIPANTES
    WHERE ID_PARTICIPANTE = p_id_participante;
END ++
DELIMITER ;

DELIMITER °°
CREATE PROCEDURE consultar_participante(
    IN p_id_usuario INT
)
BEGIN
    SELECT
        P.ID_PARTICIPANTE,
        P.ID_USUARIO,
        P.ID_CHAT
    FROM
        PARTICIPANTES P
    WHERE
       ID_USUARIO = p_id_usuario;
END °°
DELIMITER ;