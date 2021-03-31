package com.link.tracker.repositories;

import com.link.tracker.dtos.CreateLinkDTO;
import com.link.tracker.dtos.LinkDTO;
import com.link.tracker.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkTrackerRepositoryImpl implements LinkTrackerRepository {

    private final HashMap<Integer, LinkDTO> links = new HashMap<>();

    @Override
    public LinkDTO getLinkById(int id) throws ApiException {
        LinkDTO link = links.get(id);
        if (null != link) {
            if(!link.isEnable()) {
                throw new ApiException(HttpStatus.BAD_REQUEST, "La URL solicitada esta inhabilitada.");
            }
            return link;
        }
        throw new ApiException(HttpStatus.NOT_FOUND, "No se encontro la URL solicitada.");
    }

    @Override
    public int create(CreateLinkDTO link) throws ApiException {
        int linkId = getNextId();
        validateCreateLink(link);
        links.put(linkId, new LinkDTO(linkId, link.getDescription(), link.getUrl(), 0, link.getPassword(), true));
        return linkId;
    }

    @Override
    public ArrayList<LinkDTO> getAll() {
        ArrayList<LinkDTO> arrayLinks = new ArrayList<>();
        for (Map.Entry<Integer, LinkDTO>  entry : links.entrySet()) {
            arrayLinks.add(entry.getValue());
        }
        return arrayLinks;
    }

    public void validateCreateLink(CreateLinkDTO link) throws ApiException {
        for(LinkDTO linkDTO : getAll()) {
            if(link.getUrl().equals(linkDTO.getUrl()))
                throw new ApiException(HttpStatus.BAD_REQUEST, "La URL ya existe.");
        }
    }

    @Override
    public void incrementMetric(int id) throws ApiException {
        try {
            int metric = links.get(id).getMetrics();
            links.get(id).setMetrics(metric + 1);
        } catch (Exception e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo incrementar la metrica rey.");
        }
    }

    @Override
    public void enable(boolean enable, int id) throws ApiException {
        LinkDTO link = this.getLinkById(id);
        link.setEnable(enable);
    }

    public Integer getNextId() {
        return links.size() + 1;
    }
}
