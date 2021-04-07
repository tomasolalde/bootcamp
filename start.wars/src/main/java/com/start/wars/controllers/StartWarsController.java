package com.start.wars.controllers;

import com.start.wars.dtos.CharacterDTO;
import com.start.wars.services.StartWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "characters")
public class StartWarsController {

    private final StartWarsService service;

    public StartWarsController(StartWarsService startWarsService) {
        this.service = startWarsService;
    }

    @GetMapping(value = "/find")
    public ResponseEntity<ArrayList<CharacterDTO>> findCharactersByName(@RequestParam String name) {
        return new ResponseEntity<>(this.service.findCharactersByName(name), HttpStatus.OK );
    }

    @GetMapping
    public ResponseEntity<ArrayList<CharacterDTO>> getAllCharacters() {
        return new ResponseEntity<>(this.service.getCharacters(), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<String> createCharacter(@RequestBody CharacterDTO character) {
        return new ResponseEntity<String>(this.service.createCharacter(character), HttpStatus.CREATED);
    }

}
