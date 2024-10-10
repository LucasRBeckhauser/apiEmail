package br.com.lucasBeckhauser.MailSender.controller;

import br.com.lucasBeckhauser.MailSender.dto.EmailDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/email")
public class EmailController {

    public void enviarEMail (@RequestBody EmailDto emailDto) {

    }
}
