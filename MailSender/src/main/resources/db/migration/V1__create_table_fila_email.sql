CREATE SEQUENCE fila_email_seq;

CREATE TABLE fila_email (
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL('fila_email_seq'),
    destinatario VARCHAR(255) NOT NULL,
    assunto VARCHAR(255) NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    enviado BOOLEAN DEFAULT FALSE
);
