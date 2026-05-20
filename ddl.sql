-- ========================================
-- CREACIÓN DE TABLAS PARA BBDD ALQUILERES
-- PostgreSQL
-- ========================================

-- CLIENTE
CREATE TABLE cliente (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    p_apellido VARCHAR(50) NOT NULL,
    s_apellido VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL,
    dni VARCHAR(15) UNIQUE NOT NULL,
    telefono VARCHAR(20)
);

-- DIRECCION
CREATE TABLE direccion (
    id_direccion SERIAL PRIMARY KEY,
    calle VARCHAR(100),
    ciudad VARCHAR(50),
    pais VARCHAR(50),
    c_p VARCHAR(10),
    id_cliente INT NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE
);

-- CONDUCTORES
CREATE TABLE conductores (
    id_conductor SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    p_apellido VARCHAR(50) NOT NULL,
    s_apellido VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(20),
    fec_nac DATE NOT NULL,
    fec_carnet DATE NOT NULL,
    dni VARCHAR(15) UNIQUE NOT NULL,
    n_licencia VARCHAR(20) UNIQUE NOT NULL
);

-- SEGURO
CREATE TABLE seguro (
    id_seguro SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(500)
);

-- CATEGORIA
CREATE TABLE categoria (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200)
);

-- SUCURSAL
CREATE TABLE sucursal (
    id_sucursal SERIAL PRIMARY KEY,
    calle VARCHAR(100),
    ciudad VARCHAR(50),
    pais VARCHAR(50),
    c_p VARCHAR(10)
);

-- COMBUSTIBLE
CREATE TABLE combustible (
    id_comb SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200)
);

-- VEHICULO
CREATE TABLE vehiculo (
    id_vehiculo SERIAL PRIMARY KEY,
    matricula VARCHAR(7) UNIQUE NOT NULL,
    bastidor VARCHAR(17) UNIQUE NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    color VARCHAR(30),
    anio INT,
    id_categoria INT NOT NULL,
    id_sucursal INT NOT NULL,
    id_comb INT NOT NULL,
    CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
    CONSTRAINT fk_sucursal FOREIGN KEY (id_sucursal) REFERENCES sucursal(id_sucursal),
    CONSTRAINT fk_comb FOREIGN KEY (id_comb) REFERENCES combustible(id_comb)
);

-- ALQUILER
CREATE TABLE alquiler (
    id_alquiler SERIAL PRIMARY KEY,
    fecha_ini DATE NOT NULL,
    fecha_fin DATE,
    id_cliente INT NOT NULL,
    id_vehiculo INT NOT NULL,
    id_seguro INT NOT NULL,
    precio NUMERIC(10,2) NOT NULL,
    CONSTRAINT fk_cliente_alq FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE,
    CONSTRAINT fk_vehiculo_alq FOREIGN KEY (id_vehiculo) REFERENCES vehiculo(id_vehiculo) ON DELETE CASCADE,
    CONSTRAINT fk_seguro FOREIGN KEY (id_seguro) REFERENCES seguro(id_seguro)
);

-- RELACIÓN ALQUILER - CONDUCTORES (N:M)
CREATE TABLE alquiler_conductor (
    id_alquiler INT NOT NULL,
    id_conductor INT NOT NULL,
    PRIMARY KEY (id_alquiler, id_conductor),
    FOREIGN KEY (id_alquiler) REFERENCES alquiler(id_alquiler) ON DELETE CASCADE,
    FOREIGN KEY (id_conductor) REFERENCES conductores(id_conductor) ON DELETE CASCADE
);

-- EQUIPAMIENTO
CREATE TABLE equipamiento (
    id_equip SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200)
);

-- RELACIÓN VEHICULO - EQUIPAMIENTO (N:M)
CREATE TABLE vehiculo_equipamiento (
    id_vehiculo INT NOT NULL,
    id_equip INT NOT NULL,
    PRIMARY KEY (id_vehiculo, id_equip),
    FOREIGN KEY (id_vehiculo) REFERENCES vehiculo(id_vehiculo) ON DELETE CASCADE,
    FOREIGN KEY (id_equip) REFERENCES equipamiento(id_equip) ON DELETE CASCADE
);
