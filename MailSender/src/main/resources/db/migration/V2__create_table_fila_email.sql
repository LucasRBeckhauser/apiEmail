CREATE TABLE fila_email (
        id BIGSERIAL PRIMARY KEY,
        destinatario VARCHAR(255) NOT NULL,
        assunto VARCHAR(255) NOT NULL,
        mensagem VARCHAR(255) NOT NULL,
        enviado BOOLEAN DEFAULT FALSE

)