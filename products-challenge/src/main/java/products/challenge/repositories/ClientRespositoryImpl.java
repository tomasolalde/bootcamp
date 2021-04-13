package products.challenge.repositories;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import products.challenge.dtos.ClientDTO;
import products.challenge.exceptions.ApiException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ClientRespositoryImpl implements ClientRepository {

    private final List<ClientDTO> clients;
    private final String fileName = "dbClients.csv";

    public ClientRespositoryImpl() {
        clients = new ArrayList<>();
        readClients();
    }

    @Override
    public Integer createClient(ClientDTO client) throws ApiException {
        ClientDTO clientByName = getClientByName(client.getName());
        if (clientByName != null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Ya existe un cliente con ese nombre");
        }
        client.setId(clients.size() + 1);
        clients.add(client);
        writeFile();
        return client.getId();
    }

    @Override
    public List<ClientDTO> getAll() {
        return this.clients;
    }

    @Override
    public ClientDTO getClientById(Integer id) throws ApiException{
        for (ClientDTO client: clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        throw new ApiException(HttpStatus.BAD_REQUEST, "No se encontro un cliente");
    }

    private ClientDTO getClientByName(String name) {
        for (ClientDTO client: clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    private void readClients() {
        String COMMA_DELIMITER = ",";
        List<List<String>> result = null;
        try {
            result = Files.readAllLines(Paths.get(loadFile(fileName).getAbsolutePath()))
                    .stream()
                    .map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < Objects.requireNonNull(result).size(); i++) {
            List<String> parameters = result.get(i);
            ClientDTO client = new ClientDTO();
            client.setId(Integer.parseInt(parameters.get(0)));
            client.setName(parameters.get(1));
            client.setState(parameters.get(2));
            clients.add(client);
        }
    }

    private void writeFile() throws ApiException {
        try {
            FileWriter csvWriter = new FileWriter(loadFile(fileName));
            csvWriter.append("id");
            csvWriter.append(",");
            csvWriter.append("name");
            csvWriter.append(",");
            csvWriter.append("state");
            csvWriter.append("\n");
            for (ClientDTO client: clients) {
                csvWriter.append(client.getId().toString());
                csvWriter.append(",");
                csvWriter.append(client.getName());
                csvWriter.append(",");
                csvWriter.append(client.getState());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrio un error al leer el archivo");
        }
    }

    /**
     * Retorna un archivo dado el nombre
     * @param fileName nombre del archivo
     */
    public File loadFile(String fileName) {
        File file = new File("");
        try {
            file = ResourceUtils.getFile(file.getAbsolutePath()+ "/src/main/resources/" + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }
}
