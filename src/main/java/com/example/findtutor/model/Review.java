package com.example.findtutor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "stars_count")
    private int starsCount;

    @Column(name = "published_date")
    private Date publishedDate;

    @ManyToOne
    private TutorAmenities service;

    @ManyToOne
    private Student student;

}
