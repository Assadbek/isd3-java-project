package com.example.findtutor.model;

import com.example.findtutor.model.user.MyUser;
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
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private MyUser user;

    @Column(name = "about_me")
    private String aboutMe;

    private String experience;

    @Column(name = "price_hour")
    private int priceHour;

}
