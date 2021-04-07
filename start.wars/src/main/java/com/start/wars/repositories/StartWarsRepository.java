package com.start.wars.repositories;

import com.start.wars.dtos.CharacterDTO;

import java.util.ArrayList;

public interface StartWarsRepository {
    ArrayList<CharacterDTO> getCharacters();
    <T> ArrayList<T> loadArraylistDatabase(String fileName);
    String save(CharacterDTO character);
}
