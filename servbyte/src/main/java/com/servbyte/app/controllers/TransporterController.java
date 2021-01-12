package com.servbyte.app.controllers;

import com.servbyte.app.entities.Transporter;
import com.servbyte.app.services.TransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transporter")
public class TransporterController {

    @Autowired
    private TransporterService transporterService;

    @PostMapping("/signup")
    private Transporter createTransporter(@RequestBody Transporter transporter){
        return this.transporterService.save(transporter);
    }
}
