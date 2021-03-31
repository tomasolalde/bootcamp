package com.link.tracker.controllers;

import com.link.tracker.dtos.CreateLinkDTO;
import com.link.tracker.dtos.LinkDTO;
import com.link.tracker.exceptions.ApiException;
import com.link.tracker.services.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;

@RestController
@RequestMapping(value ="link-tracker")
public class LinkTrackerController {

    @Autowired
    private LinkTrackerService service;

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CreateLinkDTO link) throws ApiException {
        int createdLinkId = this.service.create(link);
        return new ResponseEntity<>(createdLinkId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ArrayList<LinkDTO>> getAll() throws ApiException {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LinkDTO> getLinkById(@PathVariable Integer id) throws ApiException {
        return new ResponseEntity<>(this.service.getLinkById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/disable/{id}")
    public HttpStatus disableLink(@PathVariable Integer id) throws ApiException {
        this.service.enable(false, id);
        return HttpStatus.OK;
    }

    @PutMapping(value = "/enable/{id}")
    public HttpStatus enableLink(@PathVariable Integer id) throws ApiException {
        this.service.enable(true, id);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/redirect/{id}")
    public RedirectView redirect(@PathVariable Integer id, @RequestParam String password) throws ApiException {
        if(password.equals(this.service.getLinkById(id).getPassword())) {
            this.service.incrementMetric(id);
            return new RedirectView(this.service.getLinkById(id).getUrl());
        }
        else {
            throw new ApiException(HttpStatus.FORBIDDEN, "Contraseña incorrecta.");
        }
    }

}
