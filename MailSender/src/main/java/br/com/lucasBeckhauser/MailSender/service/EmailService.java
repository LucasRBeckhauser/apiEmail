package br.com.lucasBeckhauser.MailSender.service;

import br.com.lucasBeckhauser.MailSender.dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void enviarEmail (EmailDto emailDto) {
        var mensagem = new SimpleMailMessage();
        mensagem.setFrom("noreply@gmail.com");
        mensagem.setTo(emailDto.email());
        mensagem.setSubject("Teste mensagem");
        mensagem.setText(emailDto.texto());
        javaMailSender.send(mensagem);
    }

}
