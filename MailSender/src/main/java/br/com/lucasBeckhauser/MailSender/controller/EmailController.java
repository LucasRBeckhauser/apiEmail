package br.com.lucasBeckhauser.MailSender.controller;

import br.com.lucasBeckhauser.MailSender.dto.EmailDto;
import br.com.lucasBeckhauser.MailSender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public void enviarEMail (@RequestBody EmailDto emailDto) {
    emailService.enviarEmail(emailDto);
    }
}
