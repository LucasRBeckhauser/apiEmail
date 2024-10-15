package br.com.lucasBeckhauser.MailSender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "fila_email")
public class FilaEmail extends EntityId{

    @Column(name = "destinatario", nullable = false)
    private String destinatario;

    @Column(name = "assunto", nullable = false)
    private String assunto;

    @Column(name = "mensagem", nullable = false)
    private String mensagem;

    @Column (name = "enviado", unique = false)
    private boolean enviado = false;

    public FilaEmail() {
    }

    public FilaEmail(String mensagem, String assunto, String destinatario) {
        this.mensagem = mensagem;
        this.assunto = assunto;
        this.destinatario = destinatario;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }
}

