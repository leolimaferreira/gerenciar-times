ALTER USER 'root'@'%' IDENTIFIED BY 'root';

CREATE USER IF NOT EXISTS 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;
CREATE TABLE time (
                      id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      nome VARCHAR(255) NOT NULL,
                      cidade VARCHAR(255),
                      estado VARCHAR(255),
                      estadio VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE jogador (
                         id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(255) NOT NULL,
                         nascimento VARCHAR(50),
                         posicao VARCHAR(100),
                         time_id BIGINT,
                         CONSTRAINT fk_time FOREIGN KEY (time_id) REFERENCES time(id)
                             ON DELETE SET NULL
                             ON UPDATE CASCADE
) ENGINE=InnoDB;
