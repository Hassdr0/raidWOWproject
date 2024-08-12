package dev.hassdro.raidwow.service;

import dev.hassdro.raidwow.repository.guildasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class guildasService {

 @Autowired
    private guildasRepository guildasRepository;
}
