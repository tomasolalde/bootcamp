package com.link.tracker.services;

import com.link.tracker.dtos.CreateLinkDTO;
import com.link.tracker.dtos.LinkDTO;
import com.link.tracker.exceptions.ApiException;
import com.link.tracker.repositories.LinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkTrackerServiceImpl implements LinkTrackerService {

    @Autowired
    private LinkTrackerRepository repository;

    @Override
    public void enable(boolean enable, int id) throws ApiException {
        this.repository.enable(enable,id);
    }

    @Override
    public LinkDTO getLinkById(int id) throws ApiException{
        return this.repository.getLinkById(id);
    }

    @Override
    public int create(CreateLinkDTO link) throws ApiException {
        this.validateUrl(link.getUrl());
        return this.repository.create(link);
    }

    @Override
    public ArrayList<LinkDTO> getAll() {
        return this.repository.getAll();
    }

    @Override
    public void incrementMetric(int id) throws ApiException {
        this.repository.incrementMetric(id);
    }

    public void validateUrl(String url) throws ApiException {
        String pattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern patt = Pattern.compile(pattern);
        Matcher matcher = patt.matcher(url);
        if(!matcher.matches())  {
            throw new ApiException(HttpStatus.BAD_REQUEST, "URL Invalida");
        }
    }
}
