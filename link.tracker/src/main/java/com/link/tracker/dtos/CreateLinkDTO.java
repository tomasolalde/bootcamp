package com.link.tracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateLinkDTO {

    private String description;
    private String url;
    private String password;

    CreateLinkDTO() {

    }
}