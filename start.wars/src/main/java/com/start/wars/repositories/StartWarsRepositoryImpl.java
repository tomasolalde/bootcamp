package com.start.wars.repositories;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.start.wars.dtos.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class StartWarsRepositoryImpl implements StartWarsRepository {

    @Override
    public ArrayList<CharacterDTO> getCharacters() {
        return loadDatabase();
    }

    public ArrayList<CharacterDTO> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("/Users/tolalde/Desktop/bootcamp/start.wars/src/main/resources/starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ArrayList<CharacterDTO>> typeRef = new TypeReference<>() {};
        ArrayList<CharacterDTO> listOfCharacters = null;

        try {
            listOfCharacters = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfCharacters;
    }

}
