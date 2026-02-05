-- Borramos la base de datos si existe y la creamos
DROP DATABASE IF EXISTS konkiburger;
CREATE DATABASE konkiburger;
USE konkiburger;

-- ============================
-- Tabla de Usuarios
-- ============================
CREATE TABLE usuario
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    username       VARCHAR(50)  NOT NULL UNIQUE,
    password       VARCHAR(255) NOT NULL,
    nombre         VARCHAR(100) NOT NULL,
    email          VARCHAR(100) NOT NULL UNIQUE,
    rol            ENUM ('cliente', 'administrador') DEFAULT 'cliente',
    direccion      VARCHAR(255),
    fecha_registro TIMESTAMP                         DEFAULT CURRENT_TIMESTAMP
);

-- ============================
-- Tabla de Categorías de Producto
-- ============================
CREATE TABLE categoria
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

-- ============================
-- Tabla de Productos
-- ============================
CREATE TABLE producto
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(100)   NOT NULL,
    descripcion  VARCHAR(255),
    precio       DECIMAL(10, 2) NOT NULL,
    stock        INT DEFAULT 0,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

-- ============================
-- Tabla de Pedidos
-- ============================
CREATE TABLE pedido
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id    INT,
    estado        ENUM ('pendiente', 'aceptado', 'cancelado', 'completado') DEFAULT 'pendiente',
    fecha         TIMESTAMP                                                 DEFAULT CURRENT_TIMESTAMP,
    hora_recogida TIME,
    metodo_pago   ENUM ('tarjeta', 'efectivo')                              DEFAULT 'efectivo',
    total         DECIMAL(10, 2),
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);

-- ============================
-- Tabla de Detalles de Pedido
-- ============================
CREATE TABLE pedido_detalle
(

    id          INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id   INT            NOT NULL,
    producto_id INT            NOT NULL,
    cantidad    INT            NOT NULL,
    subtotal    DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_pedido_detalle_pedido FOREIGN KEY (pedido_id)
        REFERENCES pedido (id) ON DELETE CASCADE,
    CONSTRAINT fk_pedido_detalle_producto FOREIGN KEY (producto_id)
        REFERENCES producto (id)
);


-- ============================
-- Tabla de Facturas
-- ============================
CREATE TABLE factura
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id      INT,
    fecha          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total          DECIMAL(10, 2),
    numero_factura VARCHAR(50) NOT NULL UNIQUE,
    FOREIGN KEY (pedido_id) REFERENCES pedido (id)
);

-- ============================
-- Tabla de Inventario de Ingredientes
-- ============================
CREATE TABLE inventario
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(100) NOT NULL,
    stock         INT DEFAULT 0,
    unidad_medida VARCHAR(20)
);

