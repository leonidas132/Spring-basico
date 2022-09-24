package com.protalento.dto;

import java.time.LocalDate;

public class UserDto {
    private Long id;
    private String name;
    private LocalDate birthday;

    public UserDto() {
    }

    public UserDto(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this. birthday = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return  birthday;
    }

    public void setBirthDate(LocalDate birthDate) {
        this. birthday= birthDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" +  birthday + '\'' +
                '}';
    }
}
