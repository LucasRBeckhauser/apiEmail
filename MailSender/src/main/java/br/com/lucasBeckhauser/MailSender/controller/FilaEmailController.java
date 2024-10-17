package br.com.lucasBeckhauser.MailSender.controller;

import br.com.lucasBeckhauser.MailSender.dto.FilaEmailDto;
import br.com.lucasBeckhauser.MailSender.service.FilaEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/filaEmails")
public class FilaEmailController {

    @Autowired
    private FilaEmailService filaEmailService;

    @PostMapping
    public ResponseEntity<Void> addEmailToQueue(@RequestBody FilaEmailDto emailDto) {
        filaEmailService.salvarEmailNaFila(emailDto);
        return ResponseEntity.ok().build();
    }
}
