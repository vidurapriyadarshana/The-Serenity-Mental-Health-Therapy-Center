package edu.ijse.therapycenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "therapy_sessions")
public class TherapySessions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String time;
    private String status;
    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Therapists therapist;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private TherapyPrograms therapyProgram;

}
