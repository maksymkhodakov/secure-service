package com.example.security.service.implementations;

import com.example.security.repo.ContactRepository;
import com.example.security.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    @Transactional
    public void updateNumberById(UUID id, String number) {
        var contact = contactRepository.findById(id)
                .orElseThrow();
        contact.setNumber(number);
        contactRepository.saveAndFlush(contact);
    }
}
