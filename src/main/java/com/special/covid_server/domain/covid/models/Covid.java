package com.special.covid_server.domain.covid.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Covid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @NonNull
    private  String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private CovidType covidType;

    @Temporal(TemporalType.DATE)
    @NonNull
    private Date date;

    private boolean isBoosted;

    public String toString(){
        return String.format("%d %s %s %s %s %s %s",id,firstName,lastName,email,covidType,isBoosted,date);
    }

}
