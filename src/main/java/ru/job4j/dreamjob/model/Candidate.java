package ru.job4j.dreamjob.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Candidate {

    private int id;

    private String name;

    private String description;

    private LocalDateTime creationDate;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
