CALL agregar_usuario(
    '555345893', 
    'password123', 
    'M', 
    '1990-05-15 00:00:00',
    "imagen.png"
);

CALL agregar_direccion(
	"Calle de la Corona",
    "3868",
    "85136",
    1
);

CALL actualizar_usuario(
	1,
    '5554873982',    
    'newpassword123', 
    'M',          
    '1988-11-23', 
    'perfil_actualizadogggg.jpg'
);

CALL actualizar_direccion(
	"Calle",
    "3860",
    "85136",
    3
);

CALL consultar_usuario_telefono_contraseña("555345893", "password123");
CALL consultar_direccion(7);

CALL agregar_chat(
	"Papu"
);

CALL editar_chat(
	4,
    "guillermo_peralta"
);

CALL consultar_chat(4);
CALL eliminar_chat(4);

CALL agregar_mensaje(
	"Hola",
    "2024-05-26 17:59:23",
    "imagen.png",
    3,
    3
);

CALL editar_mensaje(
	4,
    "HOLAAAAAAA"
);

CALL eliminar_mensaje(4);
CALL consultar_mensaje("hola");

CALL agregar_participante(
	3,3
);

CALL actualizar_participante(
	4, 1, 3
);

CALL eliminar_participante(4);
CALL consultar_participante(6);
