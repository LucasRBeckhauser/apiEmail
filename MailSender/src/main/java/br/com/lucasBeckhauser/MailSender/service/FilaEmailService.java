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
import java.util.stream.Collectors;

@Service
public class FilaEmailService {

    @Autowired
    private FilaEmailRepository filaEmailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Scheduled(fixedRate = 60000)
    public String processarFila() {
        List<FilaEmail> emailNaoEnviado = filaEmailRepository.findByEnviadoFalse();

        StringBuilder resultado = new StringBuilder();

        for (FilaEmail email : emailNaoEnviado) {
            FilaEmailDto emailDto = FilaEmailDto.fromEntity(email);
            try {
                SimpleMailMessage mensagem = new SimpleMailMessage();
                mensagem.setFrom("noreply@gmail.com");
                mensagem.setText(emailDto.mensagem());
                mensagem.setSubject(emailDto.assunto());
                mensagem.setTo(emailDto.destinatario());
                javaMailSender.send(mensagem);

                filaEmailRepository.delete(email);

                resultado.append("Email enviado para: ").append(emailDto.destinatario()).append("\n");
            } catch (Exception e) {
                resultado.append("Erro ao enviar mensagem para: ").append(emailDto.destinatario()).append(" - ").append(e.getMessage()).append("\n");
            }
        }

        return resultado.toString().isEmpty() ? "Nenhum email processado" : resultado.toString();
    }
}
