package br.com.lucasBeckhauser.MailSender.service;

import br.com.lucasBeckhauser.MailSender.dto.FilaEmailDto;
import br.com.lucasBeckhauser.MailSender.model.FilaEmail;
import br.com.lucasBeckhauser.MailSender.repository.FilaEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilaEmailService {

    @Autowired
    private FilaEmailRepository filaEmailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public void salvarEmailNaFila(FilaEmailDto emailDto) {
        FilaEmail filaEmail = emailDto.toEntity();
        filaEmailRepository.save(filaEmail);
    }

    public void enviarEProcessarFila() {
        List<FilaEmail> emailNaoEnviado = filaEmailRepository.findByEnviadoFalse();
        StringBuilder resultado = new StringBuilder();

        for (FilaEmail email : emailNaoEnviado) {
            FilaEmailDto emailDto = FilaEmailDto.fromEntity(email);
            try {
                // Enviando o e-mail
                SimpleMailMessage mensagem = new SimpleMailMessage();
                mensagem.setFrom("noreply@gmail.com");
                mensagem.setTo(emailDto.destinatario());
                mensagem.setSubject(emailDto.assunto());
                mensagem.setText(emailDto.mensagem());
                javaMailSender.send(mensagem);
                // Apagar o registro após o envio
                filaEmailRepository.delete(email);
                resultado.append("Email enviado e registro removido para: ").append(emailDto.destinatario()).append("\n");
            } catch (Exception e) {
                resultado.append("Erro ao enviar ou remover o registro para: ").append(emailDto.destinatario()).append(" - ").append(e.getMessage()).append("\n");
            }
        }

        System.out.println(resultado.toString().isEmpty() ? "Nenhum email processado" : resultado.toString());
    }

    @Scheduled(fixedRate = 60000)
    public void processarFila() {
        enviarEProcessarFila();
    }
}
