CREATE TABLE agenda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_servico VARCHAR(50),
    data_hora DATETIME,
    id_barbeiro INT,
    cliente_id INT,
    CONSTRAINT fk_agenda_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);