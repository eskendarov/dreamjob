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
public class Vacancy {

    private int id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    public Vacancy() {
        this.creationDate = LocalDateTime.now();
    }

    public Vacancy(int id, String title) {
        this.id = id;
        this.title = title;
    }
}