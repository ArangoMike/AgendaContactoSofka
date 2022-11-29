CREATE TABLE contacto (
  id int NOT NULL AUTO_INCREMENT,
  nombre_completo varchar(40) DEFAULT NULL,
  telefono varchar(15) DEFAULT NULL,
  correo_electronico varchar(50) DEFAULT NULL,
  fecha_nacimiento date DEFAULT NULL,
  activo enum('ON','OFF') DEFAULT 'ON',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb