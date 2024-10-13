package br.com.lucasBeckhauser.MailSender.repository;

import br.com.lucasBeckhauser.MailSender.model.FilaEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaEmailRepository extends JpaRepository <FilaEmail, Long> {
}
