package edu.ijse.therapycenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {

    private Long id;
    private String name;
    private String contactInfo;

//    @OneToMany(mappedBy = "patient")
//    private List<TherapySessionsDTO> therapySessions;
}