package br.com.lucasBeckhauser.MailSender.repository;

import br.com.lucasBeckhauser.MailSender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository  <User, Long> {
}
