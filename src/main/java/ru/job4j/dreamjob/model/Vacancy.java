package ru.job4j.dreamjob.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Vacancy {

    private int id;

    private String title;

    private String description;

    private LocalDateTime creationDate = LocalDateTime.now();

}