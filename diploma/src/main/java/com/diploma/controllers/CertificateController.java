package com.diploma.controllers;

import com.diploma.entities.Certificate;
import com.diploma.entities.Student;
import com.diploma.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ResponseEntity<Certificate> obtainCertificate(@RequestBody Student student) {
        return new ResponseEntity<>(certificateService.expeditCertificate(student), HttpStatus.OK);
    }

}
