-- ===============================
-- SCRIPT DML - Datos de prueba
-- ===============================

-- CATEGORIAS
INSERT INTO categoria (nombre, descripcion) VALUES
('M', 'Mini'),
('E', 'Económico'),
('C', 'Compacto'),
('S', 'Standard'),
('P', 'Premium');

-- COMBUSTIBLE
INSERT INTO combustible (nombre, descripcion) VALUES
('Gasolina', 'Motor gasolina'),
('Diésel', 'Motor diésel');

-- SUCURSAL (20 sucursales)
INSERT INTO sucursal (calle, ciudad, pais, c_p) VALUES
('Calle Sol 1', 'Madrid', 'España', '28001'),
('Calle Luna 2', 'Madrid', 'España', '28002'),
('Av. Andalucía 10', 'Sevilla', 'España', '41001'),
('Calle Real 5', 'Sevilla', 'España', '41002'),
('Gran Vía 20', 'Barcelona', 'España', '08001'),
('Diagonal 33', 'Barcelona', 'España', '08002'),
('Av. Galicia 50', 'Vigo', 'España', '36201'),
('Calle Norte 4', 'Vigo', 'España', '36202'),
('Calle Central 11', 'Valencia', 'España', '46001'),
('Av. Puerto 25', 'Valencia', 'España', '46002'),
('Calle Mayor 3', 'Bilbao', 'España', '48001'),
('Av. Libertad 7', 'Bilbao', 'España', '48002'),
('Calle Castilla 9', 'Santander', 'España', '39001'),
('Calle Prado 12', 'Toledo', 'España', '45001'),
('Calle Rioja 21', 'Logroño', 'España', '26001'),
('Calle León 15', 'León', 'España', '24001'),
('Calle Oviedo 19', 'Oviedo', 'España', '33001'),
('Calle Solana 4', 'Murcia', 'España', '30001'),
('Calle Sur 8', 'Cádiz', 'España', '11001'),
('Av. Mediterráneo 30', 'Alicante', 'España', '03001');

-- CLIENTES (20 clientes)
INSERT INTO cliente (nombre, p_apellido, s_apellido, email, dni, telefono) VALUES
('Juan', 'Pérez', 'López', 'juan.perez@example.com', '11111111A', '600111111'),
('María', 'García', 'Martín', 'maria.garcia@example.com', '22222222B', '600222222'),
('Luis', 'Sánchez', 'Ruiz', 'luis.sanchez@example.com', '33333333C', '600333333'),
('Ana', 'Fernández', 'Díaz', 'ana.fernandez@example.com', '44444444D', '600444444'),
('Pedro', 'Gómez', 'Torres', 'pedro.gomez@example.com', '55555555E', '600555555'),
('Laura', 'Martínez', 'Hernández', 'laura.martinez@example.com', '66666666F', '600666666'),
('Javier', 'Moreno', 'Jiménez', 'javier.moreno@example.com', '77777777G', '600777777'),
('Sofía', 'Álvarez', 'Cruz', 'sofia.alvarez@example.com', '88888888H', '600888888'),
('Andrés', 'Romero', 'Castro', 'andres.romero@example.com', '99999999I', '600999999'),
('Carmen', 'Navarro', 'Ortiz', 'carmen.navarro@example.com', '10101010J', '601010101'),
('Diego', 'Vega', 'Santos', 'diego.vega@example.com', '11112222K', '601111111'),
('Elena', 'Molina', 'Reyes', 'elena.molina@example.com', '12121212L', '601212121'),
('Raúl', 'Iglesias', 'Domínguez', 'raul.iglesias@example.com', '13131313M', '601313131'),
('Patricia', 'Cano', 'Flores', 'patricia.cano@example.com', '14141414N', '601414141'),
('Fernando', 'Delgado', 'Campos', 'fernando.delgado@example.com', '15151515O', '601515151'),
('Clara', 'Serrano', 'Cortés', 'clara.serrano@example.com', '16161616P', '601616161'),
('Hugo', 'Ramos', 'Luna', 'hugo.ramos@example.com', '17171717Q', '601717171'),
('Lucía', 'Giménez', 'Peña', 'lucia.gimenez@example.com', '18181818R', '601818181'),
('Pablo', 'Fuentes', 'Vidal', 'pablo.fuentes@example.com', '19191919S', '601919191'),
('Marta', 'Cabrera', 'Nieto', 'marta.cabrera@example.com', '20202020T', '602020202');

-- DIRECCIONES (25, con 5 clientes teniendo 2)
INSERT INTO direccion (calle, ciudad, pais, c_p, id_cliente) VALUES
('Calle A 1', 'Madrid', 'España', '28010', 1),
('Calle B 2', 'Madrid', 'España', '28011', 1),
('Av. C 3', 'Sevilla', 'España', '41010', 2),
('Av. D 4', 'Sevilla', 'España', '41011', 2),
('Calle E 5', 'Barcelona', 'España', '08010', 3),
('Calle F 6', 'Barcelona', 'España', '08011', 3),
('Plaza G 7', 'Valencia', 'España', '46010', 4),
('Plaza H 8', 'Valencia', 'España', '46011', 4),
('Calle I 9', 'Bilbao', 'España', '48010', 5),
('Calle J 10', 'Bilbao', 'España', '48011', 5),
('Calle K 11', 'Vigo', 'España', '36210', 6),
('Calle L 12', 'Vigo', 'España', '36211', 7),
('Av. M 13', 'Madrid', 'España', '28020', 8),
('Av. N 14', 'Madrid', 'España', '28021', 9),
('Calle O 15', 'Sevilla', 'España', '41020', 10),
('Calle P 16', 'Sevilla', 'España', '41021', 11),
('Calle Q 17', 'Barcelona', 'España', '08020', 12),
('Calle R 18', 'Barcelona', 'España', '08021', 13),
('Calle S 19', 'Valencia', 'España', '46020', 14),
('Calle T 20', 'Valencia', 'España', '46021', 15),
('Calle U 21', 'Bilbao', 'España', '48020', 16),
('Calle V 22', 'Bilbao', 'España', '48021', 17),
('Calle W 23', 'Vigo', 'España', '36220', 18),
('Calle X 24', 'Vigo', 'España', '36221', 19),
('Calle Y 25', 'Madrid', 'España', '28030', 20);

-- CONDUCTORES (30)
INSERT INTO conductores (nombre, p_apellido, s_apellido, email, telefono, fec_nac, fec_carnet, dni, n_licencia) VALUES
('Carlos', 'Muñoz', 'Soto', 'carlos.munoz@example.com', '610111111', '1985-01-15', '2003-02-20', '30000000A', '30000000A'),
('Beatriz', 'López', 'Gil', 'beatriz.lopez@example.com', '610222222', '1990-05-10', '2008-06-12', '30000000B', '30000000B'),
('Daniel', 'Ruiz', 'Ortega', 'daniel.ruiz@example.com', '610333333', '1987-03-22', '2005-04-30', '30000000C', '30000000C'),
('Rosa', 'Hernández', 'Cano', 'rosa.hernandez@example.com', '610444444', '1992-07-08', '2010-09-01', '30000000D', '30000000D'),
('Álvaro', 'Torres', 'Ramos', 'alvaro.torres@example.com', '610555555', '1983-11-12', '2001-12-20', '30000000E', '30000000E'),
('Gloria', 'Díaz', 'Pascual', 'gloria.diaz@example.com', '610666666', '1986-02-05', '2004-03-15', '30000000F', '30000000F'),
('Francisco', 'Reyes', 'Guerrero', 'francisco.reyes@example.com', '610777777', '1979-09-14', '1997-11-01', '30000000G', '30000000G'),
('Teresa', 'Castro', 'Morales', 'teresa.castro@example.com', '610888888', '1991-04-28', '2009-05-10', '30000000H', '30000000H'),
('Sergio', 'Vargas', 'Crespo', 'sergio.vargas@example.com', '610999999', '1984-06-19', '2002-07-01', '30000000I', '30000000I'),
('Inés', 'Román', 'Peñalver', 'ines.roman@example.com', '611000000', '1993-12-30', '2011-02-01', '30000000J', '30000000J'),
('Óscar', 'Campos', 'Muñoz', 'oscar.campos@example.com', '611111111', '1981-01-11', '1999-03-01', '30000000K', '30000000K'),
('Natalia', 'Méndez', 'Cordero', 'natalia.mendez@example.com', '611222222', '1994-05-09', '2012-07-01', '30000000L', '30000000L'),
('Iván', 'Pastor', 'Nieto', 'ivan.pastor@example.com', '611333333', '1982-08-17', '2000-09-01', '30000000M', '30000000M'),
('Silvia', 'Peña', 'Lara', 'silvia.pena@example.com', '611444444', '1995-02-12', '2013-04-01', '30000000N', '30000000N'),
('Manuel', 'Cabrera', 'Vega', 'manuel.cabrera@example.com', '611555555', '1978-07-25', '1996-08-01', '30000000O', '30000000O'),
('Julia', 'Luna', 'Salas', 'julia.luna@example.com', '611666666', '1996-10-10', '2014-11-01', '30000000P', '30000000P'),
('Roberto', 'Durán', 'Calvo', 'roberto.duran@example.com', '611777777', '1989-03-03', '2007-04-01', '30000000Q', '30000000Q'),
('Cristina', 'Nieto', 'Rivas', 'cristina.nieto@example.com', '611888888', '1997-01-01', '2015-02-01', '30000000R', '30000000R'),
('Miguel', 'Benítez', 'Marín', 'miguel.benitez@example.com', '611999999', '1980-09-19', '1998-10-01', '30000000S', '30000000S'),
('Paula', 'Ferrer', 'Romero', 'paula.ferrer@example.com', '612000000', '1998-04-20', '2016-05-01', '30000000T', '30000000T'),
('Alfonso', 'Ibañez', 'Santos', 'alfonso.ibanez@example.com', '612111111', '1977-06-30', '1995-07-01', '30000000U', '30000000U'),
('Victoria', 'Soto', 'Garrido', 'victoria.soto@example.com', '612222222', '1992-08-14', '2010-09-01', '30000000V', '30000000V'),
('Tomás', 'Guerrero', 'Rey', 'tomas.guerrero@example.com', '612333333', '1988-10-21', '2006-11-01', '30000000W', '30000000W'),
('Eva', 'Jiménez', 'Muñoz', 'eva.jimenez@example.com', '612444444', '1999-12-12', '2017-01-01', '30000000X', '30000000X'),
('Adrián', 'Mora', 'López', 'adrian.mora@example.com', '612555555', '1985-05-18', '2003-06-01', '30000000Y', '30000000Y'),
('Isabel', 'Ortega', 'Navarro', 'isabel.ortega@example.com', '612666666', '1993-07-07', '2011-08-01', '30000000Z', '30000000Z'),
('Antonio', 'Vidal', 'León', 'antonio.vidal@example.com', '612777777', '1976-11-15', '1994-12-01', '30000001A', '30000001A'),
('Mónica', 'Gallardo', 'Serrano', 'monica.gallardo@example.com', '612888888', '1990-09-09', '2008-10-01', '30000001B', '30000001B'),
('Jesús', 'Calderón', 'Puente', 'jesus.calderon@example.com', '612999999', '1984-12-25', '2002-01-01', '30000001C', '30000001C'),
('Sara', 'Esteban', 'Bravo', 'sara.esteban@example.com', '613000000', '1991-03-05', '2009-04-01', '30000001D', '30000001D');

-- SEGUROS (4 tipos)
INSERT INTO seguro (nombre, descripcion) VALUES
('A terceros', 'Cobertura básica contra daños a terceros'),
('Franquicia 300', 'Seguro con franquicia de 300 euros'),
('Franquicia 150', 'Seguro con franquicia de 150 euros'),
('A todo riesgo', 'Cobertura completa sin franquicia');

-- EQUIPAMIENTO (10 tipos)
INSERT INTO equipamiento (nombre, descripcion) VALUES
('Climatizador', 'Sistema de climatización automático'),
('GPS', 'Sistema de navegación por satélite'),
('Elevalunas eléctrico', 'Apertura y cierre eléctrico de ventanas'),
('Bluetooth', 'Conectividad manos libres'),
('Airbags', 'Bolsas de aire de seguridad'),
('ABS', 'Sistema antibloqueo de frenos'),
('Sensor aparcamiento', 'Asistente de aparcamiento'),
('Cámara trasera', 'Cámara de visión trasera'),
('Control crucero', 'Control de velocidad crucero'),
('Asientos calefactables', 'Calefacción en asientos delanteros');

-- INSERCIÓN DE 50 VEHÍCULOS
INSERT INTO vehiculo (matricula, bastidor, marca, modelo, color, anio, id_categoria, id_sucursal, id_comb) VALUES
('1234BCD','WVWZZZ1JZXW000001','Seat','Ibiza','Rojo',2015,1,1,1),
('2345FGH','VSSZZZ6JZXR000002','Toyota','Yaris','Negro',2017,1,2,2),
('3456JKL','VF7ZZZC3ZXR000003','Citroën','C3','Blanco',2018,1,3,1),
('4567MNP','W0L0XCF0814000004','Opel','Corsa','Gris',2020,1,4,2),
('5678RST','VF1CLIO0X54000005','Renault','Clio','Azul',2019,2,5,1),
('6789VWX','VF3CCHMRTR0000006','Peugeot','208','Rojo',2016,2,6,2),
('7890YZB','WVWZZZ6RZXR000007','Volkswagen','Polo','Negro',2014,2,7,1),
('8901CDF','WF0JXXGAJJ0000008','Ford','Fiesta','Blanco',2013,2,8,2),
('9012FGH','VSSZZZ5FZVR000009','Seat','León','Gris',2021,3,9,1),
('1122JKL','WVWZZZ1JZVR000010','Volkswagen','Golf','Rojo',2020,3,10,2),
('2233MNP','VF3C5HNZXR000011','Peugeot','308','Azul',2017,3,11,1),
('3344RST','W0L0XCF0812000012','Opel','Astra','Negro',2018,3,12,2),
('4455VWX','VF1BM0F0XJ0000013','Renault','Mégane','Blanco',2016,3,13,1),
('5566YZB','WAUZZZ8V0JA000014','Audi','A3','Gris',2019,3,14,2),
('6677CDF','WF0EXXGBBEU000015','Ford','Mondeo','Azul',2015,4,15,1),
('7788FGH','WVWZZZ3CZWE000016','Volkswagen','Passat','Negro',2013,4,16,2),
('8899JKL','JTDKB20U793000017','Toyota','Corolla','Rojo',2018,4,17,1),
('9900MNP','VF7C4HRZR0000018','Citroën','C4','Blanco',2020,4,18,2),
('1111RST','WDB2020201F000019','Mercedes','Clase C','Gris',2021,4,19,1),
('2222VWX','WBA3A9C56DF000020','BMW','Serie 3','Negro',2017,4,20,2),
('3333YZB','WAUZZZF49KA000021','Audi','A4','Azul',2022,5,1,1),
('4444CDF','WBA5A71020D000022','BMW','Serie 5','Blanco',2021,5,2,2),
('5555FGH','WDB2120201A000023','Mercedes','Clase E','Negro',2020,5,3,1),
('6666JKL','WDB1760421V000024','Mercedes','Clase A','Gris',2019,5,4,2),
('7777MNP','WAUZZZ8X0HB000025','Audi','A1','Rojo',2018,5,5,1),
('8888RST','VSSZZZ6JZVR000026','Seat','Ibiza','Negro',2014,1,6,2),
('9999VWX','JTDKN3DP7C3000027','Toyota','Yaris','Blanco',2015,1,7,1),
('1212YZB','VF7ZZZC3ZVR000028','Citroën','C3','Gris',2017,1,8,2),
('2323CDF','W0L0SDL0856000029','Opel','Corsa','Azul',2016,1,9,1),
('3434FGH','VF1CLIO0XJ0000030','Renault','Clio','Rojo',2018,2,10,2),
('4545JKL','VF3CCFHZXR000031','Peugeot','208','Negro',2019,2,11,1),
('5656MNP','WVWZZZ6RZWR000032','Volkswagen','Polo','Gris',2020,2,12,2),
('6767RST','WF0JXXGAJJ2000033','Ford','Fiesta','Blanco',2013,2,13,1),
('7878VWX','VSSZZZ5FZVR000034','Seat','León','Negro',2015,3,14,2),
('8989YZB','WVWZZZ1JZVR000035','Volkswagen','Golf','Azul',2016,3,15,1),
('9090CDF','VF3C5HNZXR000036','Peugeot','308','Blanco',2018,3,16,2),
('1010FGH','W0L0XCF0812000037','Opel','Astra','Rojo',2019,3,17,1),
('1112JKL','VF1BM0F0XH0000038','Renault','Mégane','Negro',2020,3,18,2),
('1213MNP','WAUZZZ8V0KA000039','Audi','A3','Gris',2021,3,19,1),
('1314RST','WF0EXXGBBEM000040','Ford','Mondeo','Blanco',2017,4,20,2),
('1415VWX','WVWZZZ3CZWR000041','Volkswagen','Passat','Rojo',2016,4,1,1),
('1516YZB','JTDKB20U7A3000042','Toyota','Corolla','Azul',2018,4,2,2),
('1617CDF','VF7C4HRZR0000043','Citroën','C4','Negro',2020,4,3,1),
('1718FGH','WDB2020201H000044','Mercedes','Clase C','Gris',2019,4,4,2),
('1819JKL','WBA3A9C56EF000045','BMW','Serie 3','Blanco',2015,4,5,1),
('1920MNP','WAUZZZF49KA000046','Audi','A4','Negro',2022,5,6,2),
('2021RST','WBA5A71020E000047','BMW','Serie 5','Rojo',2021,5,7,1),
('2122VWX','WDB2120201B000048','Mercedes','Clase E','Azul',2020,5,8,2),
('2223YZB','WDB1760421K000049','Mercedes','Clase A','Blanco',2017,5,9,1),
('2324CDF','WAUZZZ8X0HB000050','Audi','A1','Gris',2016,5,10,2);


-- ALQUILERES (30 registros)
INSERT INTO alquiler (id_cliente, id_vehiculo, id_seguro, fecha_ini, fecha_fin, precio) VALUES
(1, 5, 1, '2022-01-10', '2022-01-15', 150.00),
(2, 10, 2, '2022-02-05', '2022-02-12', 220.00),
(3, 15, 3, '2022-03-01', '2022-03-08', 310.00),
(4, 20, 4, '2022-03-20', '2022-03-25', 180.00),
(5, 25, 2, '2022-04-02', '2022-04-09', 250.00),
(6, 30, 1, '2022-05-10', '2022-05-18', 200.00),
(7, 35, 3, '2022-06-01', '2022-06-07', 330.00),
(8, 40, 4, '2022-06-15', '2022-06-20', 190.00),
(9, 45, 1, '2022-07-01', '2022-07-05', 160.00),
(10, 50, 2, '2022-07-20', '2022-07-27', 280.00),
(11, 1, 3, '2022-08-05', '2022-08-12', 310.00),
(12, 2, 4, '2022-08-15', '2022-08-22', 190.00),
(13, 3, 1, '2022-09-01', '2022-09-05', 150.00),
(14, 4, 2, '2022-09-10', '2022-09-17', 230.00),
(15, 6, 3, '2022-09-20', '2022-09-27', 300.00),
(16, 7, 4, '2022-10-01', '2022-10-08', 180.00),
(17, 8, 1, '2022-10-15', '2022-10-20', 170.00),
(18, 9, 2, '2022-11-01', '2022-11-07', 260.00),
(19, 11, 3, '2022-11-15', '2022-11-22', 310.00),
(20, 12, 4, '2022-12-01', '2022-12-05', 190.00),
(1, 13, 2, '2023-01-10', '2023-01-17', 240.00),
(2, 14, 1, '2023-02-01', '2023-02-05', 150.00),
(3, 16, 4, '2023-02-20', '2023-02-27', 200.00),
(4, 17, 3, '2023-03-01', '2023-03-08', 330.00),
(5, 18, 1, '2023-03-15', '2023-03-20', 180.00),
(6, 19, 2, '2023-04-01', '2023-04-07', 270.00),
(7, 21, 3, '2023-04-10', '2023-04-17', 350.00),
(8, 22, 4, '2023-05-01', '2023-05-05', 190.00),
(9, 23, 1, '2023-05-15', '2023-05-22', 160.00),
(10, 24, 2, '2023-06-01', '2023-06-08', 280.00);

-- Alquiler-conductor (50)

INSERT INTO alquiler_conductor (id_alquiler, id_conductor) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(4, 6),
(4, 7),
(5, 8),
(6, 9),
(7, 10),
(7, 11),
(8, 12),
(9, 13),
(9, 14),
(10, 16),
(11, 16),
(12, 17),
(12, 18),
(13, 19),
(14, 20),
(15, 21),
(15, 22),
(16, 23),
(17, 24),
(18, 25),
(18, 26),
(19, 27),
(20, 28),
(21, 29),
(22, 30),
(23, 1),
(24, 2),
(25, 3),
(25, 4),
(26, 5),
(27, 6),
(27, 7),
(28, 8),
(29, 9),
(29, 10),
(30, 11),
(30, 12),
(5, 13),
(6, 14),
(10, 15),
(15, 16),
(20, 17),
(25, 18),
(30, 19),
(30, 20);


-- INSERCIÓN EN vehiculo_equipamiento
INSERT INTO vehiculo_equipamiento (id_vehiculo, id_equip) VALUES
-- Vehículo 1
(1,1),(1,2),(1,5),
-- Vehículo 2
(2,2),(2,3),(2,6),
-- Vehículo 3
(3,1),(3,4),(3,7),
-- Vehículo 4
(4,5),(4,6),(4,8),
-- Vehículo 5
(5,1),(5,9),
-- Vehículo 6
(6,2),(6,4),(6,10),
-- Vehículo 7
(7,3),(7,5),
-- Vehículo 8
(8,6),(8,7),(8,8),
-- Vehículo 9
(9,2),(9,9),
-- Vehículo 10
(10,1),(10,2),(10,3),(10,4),(10,5),(10,6),
-- Vehículo 11
(11,3),(11,7),
-- Vehículo 12
(12,5),(12,8),(12,9),
-- Vehículo 13
(13,1),(13,2),(13,10),
-- Vehículo 14
(14,4),(14,6),
-- Vehículo 15
(15,7),(15,8),(15,9),
-- Vehículo 16
(16,2),(16,5),
-- Vehículo 17
(17,3),(17,6),(17,10),
-- Vehículo 18
(18,1),(18,2),(18,3),(18,4),(18,5),(18,6),(18,7),(18,8),(18,9),(18,10),
-- Vehículo 19
(19,5),(19,9),
-- Vehículo 20
(20,2),(20,8),(20,10),
-- Vehículo 21
(21,1),(21,3),(21,5),
-- Vehículo 22
(22,4),(22,6),(22,7),
-- Vehículo 23
(23,2),(23,8),
-- Vehículo 24
(24,5),(24,9),(24,10),
-- Vehículo 25
(25,1),(25,4),
-- Vehículo 26
(26,3),(26,6),(26,7),
-- Vehículo 27
(27,2),(27,5),(27,9),
-- Vehículo 28
(28,1),(28,7),
-- Vehículo 29
(29,4),(29,8),(29,10),
-- Vehículo 30
(30,2),(30,3),(30,5),
-- Vehículo 31
(31,6),(31,9),
-- Vehículo 32
(32,1),(32,2),(32,8),
-- Vehículo 33
(33,3),(33,7),(33,10),
-- Vehículo 34
(34,4),(34,5),
-- Vehículo 35
(35,2),(35,6),(35,9),
-- Vehículo 36
(36,1),(36,3),(36,8),
-- Vehículo 37
(37,5),(37,7),
-- Vehículo 38
(38,2),(38,4),(38,10),
-- Vehículo 39
(39,1),(39,6),(39,9),
-- Vehículo 40
(40,3),(40,5),(40,8),
-- Vehículo 41
(41,2),(41,7),
-- Vehículo 42
(42,1),(42,4),(42,9),
-- Vehículo 43
(43,3),(43,6),(43,10),
-- Vehículo 44
(44,2),(44,5),(44,8),
-- Vehículo 45
(45,1),(45,7),
-- Vehículo 46
(46,4),(46,6),(46,9),
-- Vehículo 47
(47,2),(47,3),(47,10),
-- Vehículo 48
(48,1),(48,5),(48,8),
-- Vehículo 49
(49,6),(49,7),
-- Vehículo 50
(50,2),(50,4),(50,9);
