package br.com.lucasBeckhauser.MailSender.dto;

import br.com.lucasBeckhauser.MailSender.model.User;

public record UserDto(String nome, String email) {

    public static UserDto fromEntity(User user) {
        return new UserDto(user.getEmail(), user.getNome());
    }

    public User toEntity() {
        return new User(this.email, this.nome);
    }

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public String email() {
        return email;
    }


}
