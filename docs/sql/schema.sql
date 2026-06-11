CREATE DATABASE IF NOT EXISTS projeto_final;
USE projeto_final;

CREATE TABLE Cliente (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    celular VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE Garcom (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    turno VARCHAR(10) NOT NULL
);

CREATE TABLE Mesa (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    quantidadeLugares INT NOT NULL,
    setor VARCHAR(50) NOT NULL,
    status VARCHAR(10) NOT NULL
);

CREATE TABLE Prato (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    tipo VARCHAR(20) NOT NULL,
    preco DECIMAL(10,2) NOT NULL
);

CREATE TABLE Pedido (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    status VARCHAR(15) NOT NULL,
    cliente_id INT NOT NULL,
    garcom_id INT NOT NULL,
    mesa_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(codigo),
    FOREIGN KEY (garcom_id) REFERENCES Garcom(codigo),
    FOREIGN KEY (mesa_id) REFERENCES Mesa(codigo)
);

CREATE TABLE ItemPedido (
    pedido_id INT NOT NULL,
    prato_id INT NOT NULL,
    quantidade INT NOT NULL,
    precoUnitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (pedido_id, prato_id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(codigo),
    FOREIGN KEY (prato_id) REFERENCES Prato(codigo)
);