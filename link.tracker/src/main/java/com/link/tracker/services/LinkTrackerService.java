package com.link.tracker.services;

import com.link.tracker.dtos.CreateLinkDTO;
import com.link.tracker.dtos.LinkDTO;
import com.link.tracker.exceptions.ApiException;

import java.util.ArrayList;

public interface LinkTrackerService {
    LinkDTO getLinkById(int id) throws ApiException;
    int create(CreateLinkDTO link) throws ApiException;
    ArrayList<LinkDTO> getAll();
    void incrementMetric(int id) throws ApiException;
}
