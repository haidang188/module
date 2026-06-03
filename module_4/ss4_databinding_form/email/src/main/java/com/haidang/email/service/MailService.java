package com.haidang.email.service;

import com.haidang.email.model.Mail;
import com.haidang.email.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private MailRepository mailRepository;

    public Mail getMail() {
        return mailRepository.getMail();
    }

    public void updateMail(Mail mail) {
        mailRepository.updateMail(mail);
    }

}
