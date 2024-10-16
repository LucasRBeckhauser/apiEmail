package br.com.lucasBeckhauser.MailSender.dto;

import java.util.List;

public record UserEmailRequest(UserDto user, List<FilaEmailDto> emails) {
}
