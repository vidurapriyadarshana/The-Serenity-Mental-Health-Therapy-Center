package edu.ijse.therapycenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "therapy_programs")
public class TherapyProgram implements SuperEntity{

    @Id
    private String programId;
    private String name;
    private String duration;
    private double fee;

    @OneToMany(mappedBy = "therapyProgram" , cascade = CascadeType.ALL)
    private List<TherapySession> therapySessions;
}
