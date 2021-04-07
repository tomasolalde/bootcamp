package com.start.wars.services;

import com.start.wars.dtos.CharacterDTO;
import com.start.wars.repositories.StartWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StartWarsServiceImpl implements StartWarsService {

    @Autowired
    StartWarsRepository repository;

    @Override
    public ArrayList<CharacterDTO> findCharactersByName(String name) {
        ArrayList<CharacterDTO> foundCharacters = new ArrayList<>();
        ArrayList<CharacterDTO> characters = this.repository.getCharacters();

        for(CharacterDTO character : characters) {
            String stringToSearch = character.name;
            Pattern pattern = Pattern.compile(name);
            Matcher m = pattern.matcher(stringToSearch);
            if (m.find()) foundCharacters.add(character);
        }

        return foundCharacters;
    }

    @Override
    public ArrayList<CharacterDTO> getCharacters() {
        return this.repository.getCharacters();
    }

    @Override
    public String createCharacter(CharacterDTO character) {
        return this.repository.save(character);
    }

}
