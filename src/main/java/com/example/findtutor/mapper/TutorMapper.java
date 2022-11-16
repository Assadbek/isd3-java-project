package com.example.findtutor.mapper;

import com.example.findtutor.model.Tutor;
import com.example.findtutor.model.TutorAmenities;
import com.example.findtutor.model.dto.TutorDetails;

import java.util.List;

public class TutorMapper {

    private TutorMapper() {
    }

    public static TutorDetails toTutorDetails(Tutor tutor, List<TutorAmenities> tutorAmenities) {
        return TutorDetails.builder()
                .id(tutor.getId())
                .name(tutor.getUser().getName())
                .surname(tutor.getUser().getSurname())
                .aboutMe(tutor.getAboutMe())
                .education(tutor.getEducation())
                .experience(tutor.getExperience())
                .tutorAmenitiesList(tutorAmenities)
                .build();
    }

}
