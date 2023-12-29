package ru.job4j.dreamjob.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Vacancy {

    private int id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    public Vacancy(int id, String title) {
        this.id = id;
        this.title = title;
    }
}