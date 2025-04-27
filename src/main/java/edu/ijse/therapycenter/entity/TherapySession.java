package edu.ijse.therapycenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "therapy_sessions")
public class TherapySession implements SuperEntity{

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String date;
    private String time;
    private String status;

    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Therapist therapist;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private TherapyProgram therapyProgram;

    @OneToMany(mappedBy = "therapySession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;
}
