package ru.job4j.dreamjob.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Candidate {

    private int id;

    private String name;

    private String description;

    private LocalDateTime creationDate;

    public Candidate() {
        this.creationDate = LocalDateTime.now();
    }

}
