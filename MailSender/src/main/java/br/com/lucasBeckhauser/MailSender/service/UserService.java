package br.com.lucasBeckhauser.MailSender.service;

import br.com.lucasBeckhauser.MailSender.dto.UserDto;
import br.com.lucasBeckhauser.MailSender.model.User;
import br.com.lucasBeckhauser.MailSender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserDto> criarUsuario(UserDto userDto) {
        User user = userDto.toEntity();
        userRepository.save(user);
        return ResponseEntity.ok(UserDto.fromEntity(user));
    }
}
