package com.example.findtutor.model.dto;

import com.example.findtutor.model.Review;
import com.example.findtutor.model.TutorAmenities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TutorDetails {

    private Long id;

    private String name;

    private String surname;

    private String aboutMe;

    private String education;

    private String experience;

    private Collection<TutorAmenities> tutorAmenitiesList;

}
