package com.example.findtutor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tutor_service")
public class TutorAmenities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Tutor tutor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;

    @Column(name = "price_for_hour")
    private Long priceForHour;

}
