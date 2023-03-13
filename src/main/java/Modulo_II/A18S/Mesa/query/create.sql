CREATE TABLE IF NOT EXISTS endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(36) NOT NULL,
    numero VARCHAR(12) NOT NULL,
    cidade VARCHAR(36) NOT NULL,
    bairro VARCHAR(36) NOT NULL
);

CREATE TABLE IF NOT EXISTS paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(36) NOT NULL,
    sobrenome VARCHAR(36) NOT NULL,
    rg VARCHAR(36) NOT NULL,
    data_nascimento DATE NOT NULL,
    endereco_id INT NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE IF NOT EXISTS dentista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    sobrenome VARCHAR(100),
    matricula VARCHAR(100) UNIQUE
);