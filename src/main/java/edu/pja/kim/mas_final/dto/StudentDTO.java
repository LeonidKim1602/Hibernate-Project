package edu.pja.kim.mas_final.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {
    private Long id;
    private String username;
    private String email;
    private LocalDate enrollmentDate;

    @Override
    public String toString() {
        return username + " - " + email + " - " + enrollmentDate;
    }
}
