package ru.job4j.dreamjob.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileDto {

    private String name;

    private byte[] content;
}