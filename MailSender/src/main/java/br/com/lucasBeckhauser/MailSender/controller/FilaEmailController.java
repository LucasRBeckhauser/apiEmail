package br.com.lucasBeckhauser.MailSender.controller;

import br.com.lucasBeckhauser.MailSender.dto.FilaEmailDto;
import br.com.lucasBeckhauser.MailSender.dto.UserEmailRequest;
import br.com.lucasBeckhauser.MailSender.service.FilaEmailService;
import br.com.lucasBeckhauser.MailSender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filaEmails")
public class FilaEmailController {

    @Autowired
    private FilaEmailService filaEmailService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUserWithEmails(@RequestBody UserEmailRequest userEmailRequest) {
        // Criar o usuário
        userService.criarUsuario(userEmailRequest.user());

        // Criar e salvar os e-mails na fila
        List<FilaEmailDto> emails = userEmailRequest.emails();
        for (FilaEmailDto email : emails) {
            filaEmailService.salvarEmailNaFila(email);
        }

        // Enviar e-mails e depois apagar do banco de dados
        filaEmailService.enviarEProcessarFila();

        return ResponseEntity.ok().build();
    }
}
