package br.com.lucasBeckhauser.MailSender.model;

import jakarta.persistence.*;

@MappedSuperclass
public class EntityId {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fila_email_seq")
    @SequenceGenerator(name = "fila_email_seq", sequenceName = "fila_email_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

