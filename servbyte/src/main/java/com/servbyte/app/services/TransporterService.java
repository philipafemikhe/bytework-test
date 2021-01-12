package com.servbyte.app.services;

import com.servbyte.app.entities.Transporter;
import com.servbyte.app.repositories.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransporterService {
    @Autowired
    private TransporterRepository transporterRepository;

    public Transporter save(Transporter transporter) {
        return this.transporterRepository.save(transporter);
    }
}
