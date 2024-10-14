package br.com.lucasBeckhauser.MailSender.controller;

import br.com.lucasBeckhauser.MailSender.dto.FilaEmailDto;
import br.com.lucasBeckhauser.MailSender.dto.UserDto;
import br.com.lucasBeckhauser.MailSender.service.FilaEmailService;
import br.com.lucasBeckhauser.MailSender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/filaEmails")
public class FilaEmailController {

    @Autowired
    private FilaEmailService filaEmailService;

    @Autowired
    private UserService userService;

    @PostMapping
    public void enviarEMail (@RequestBody FilaEmailDto filaEmail, UserDto user) {



    }
}

// Lembrando que ao criar um usuário novo deve ser criado um registro nessa fila de e-mail.
//Entao será criado um e-mail e logo após, será enviado um registro de e-mail
//Então na hora de fazer o post, chamará o usuário e depois o e-mail será enviado
