package br.com.lucasBeckhauser.MailSender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class User extends EntityId {

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;


    public User() {
    }

    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
