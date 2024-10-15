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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        // Criar o usuário
        ResponseEntity<UserDto> userResponse = userService.criarUsuario(userDto);

        // Criar e salvar o e-mail na fila
        FilaEmailDto filaEmailDto = new FilaEmailDto(
                userDto.email(),
                "Bem-vindo, " + userDto.nome(),
                "Obrigado por se cadastrar!"
        );
        filaEmailService.salvarEmailNaFila(filaEmailDto);

        // Enviar e-mails e depois apagar do banco de dados
        filaEmailService.enviarEProcessarFila();

        return ResponseEntity.ok().build();
    }
}
