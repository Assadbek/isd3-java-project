package com.example.findtutor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {
    private int id;
    private String name;
    private String surname;
    private List<Publication> publications;
}
