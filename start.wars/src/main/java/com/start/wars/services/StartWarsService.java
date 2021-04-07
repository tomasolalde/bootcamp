package com.start.wars.services;

import com.start.wars.dtos.CharacterDTO;

import java.util.ArrayList;

public interface StartWarsService {
    ArrayList<CharacterDTO> findCharactersByName(String name);
    ArrayList<CharacterDTO> getCharacters();
    String createCharacter(CharacterDTO character);
}
