package com.testing.hamcrest.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Student {

    private String name;
    private String major;
    private Double gpa;
}
