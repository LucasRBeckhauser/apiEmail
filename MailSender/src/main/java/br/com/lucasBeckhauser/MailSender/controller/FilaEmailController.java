package br.com.lucasBeckhauser.MailSender.controller;

import br.com.lucasBeckhauser.MailSender.dto.FilaEmailDto;
import br.com.lucasBeckhauser.MailSender.dto.UserDto;
import br.com.lucasBeckhauser.MailSender.service.FilaEmailService;
import br.com.lucasBeckhauser.MailSender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/filaEmails")
public class FilaEmailController {

    @Autowired
    private FilaEmailService filaEmailService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUserWithEmail(@RequestBody UserDto userDto, @RequestBody FilaEmailDto filaEmailDto) {
        // Criar o usuário
        userService.criarUsuario(userDto);

        // Criar e salvar o e-mail na fila
        filaEmailService.salvarEmailNaFila(filaEmailDto);

        // Enviar e-mails e depois apagar do banco de dados
        filaEmailService.enviarEProcessarFila();

        return ResponseEntity.ok().build();
    }
}