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
    private int userId;
    private List<Publication> publications;
}
