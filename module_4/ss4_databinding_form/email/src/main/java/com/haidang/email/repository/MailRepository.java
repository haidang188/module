package com.haidang.email.repository;

import com.haidang.email.model.Mail;
import org.springframework.stereotype.Repository;

@Repository
public class MailRepository {
    private Mail mail = new Mail(
            "English",
            25,
            true,
            "Thor\nKing, Asgard"
    );

    public Mail getMail() {
        return mail;
    }

    public void updateMail(Mail mail) {
        this.mail = mail;
    }
}
