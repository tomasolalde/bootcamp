package com.start.wars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.start.wars.dtos.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Repository
public class StartWarsRepositoryImpl implements StartWarsRepository {

    @Override
    public ArrayList<CharacterDTO> getCharacters() {
        return loadArraylistDatabase("starwars.json");
    }

    @Override
    public String save(CharacterDTO character) {
        String fileName = "starwars.json";
        Path JSONFilesDirectory = Paths.get("src", "main", "resources", "starwars.json");
        String absolutePath = JSONFilesDirectory.toFile().getAbsolutePath();
        ArrayList<CharacterDTO> characters = loadArraylistDatabase(fileName);
        characters.add(character);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(absolutePath), String.valueOf(characters));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return character.getName();
    }

    @Override
    public <T> ArrayList<T> loadArraylistDatabase(String fileName) {
        File file = loadFile(fileName);
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ArrayList<T>> typeRef = new TypeReference<>() {
        };
        ArrayList<T> listOfCharacters = null;
        try {
            listOfCharacters = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfCharacters;
    }

    public File loadFile(String fileName) {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:" + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }

}
