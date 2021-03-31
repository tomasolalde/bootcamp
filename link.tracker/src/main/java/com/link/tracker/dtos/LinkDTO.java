package com.link.tracker.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDTO {

    private int id;
    private String description;
    private String url;
    private int metrics;
    private String password;

    LinkDTO() {
    }

}
