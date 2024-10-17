package br.com.lucasBeckhauser.MailSender.dto;

import br.com.lucasBeckhauser.MailSender.model.FilaEmail;

public record FilaEmailDto(String destinatario, String assunto, String mensagem) {
    public static FilaEmailDto fromEntity(FilaEmail filaEmail) {
        return new FilaEmailDto(
                filaEmail.getDestinatario(),
                filaEmail.getAssunto(),
                filaEmail.getMensagem()
        );
    }

    public FilaEmail toEntity() {
        return new FilaEmail(
                this.destinatario,
                this.assunto,
                this.mensagem
        );
    }
}
