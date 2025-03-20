package edu.ijse.therapycenter;

import edu.ijse.therapycenter.config.FactoryConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.ijse.therapycenter.entity.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
       launch();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Users admin = new Users();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setRole("Admin");

            Users receptionist = new Users();
            receptionist.setUsername("receptionist");
            receptionist.setPassword("pass123");
            receptionist.setRole("Receptionist");

            session.persist(admin);
            session.persist(receptionist);

            Therapists therapist1 = new Therapists();
            therapist1.setName("Dr. John Smith");
            therapist1.setSpecialization("Physiotherapy");

            Therapists therapist2 = new Therapists();
            therapist2.setName("Dr. Emily Brown");
            therapist2.setSpecialization("Psychotherapy");

            session.persist(therapist1);
            session.persist(therapist2);

            Patients patient1 = new Patients();
            patient1.setName("Alice Johnson");
            patient1.setContactInfo("alice@example.com");

            Patients patient2 = new Patients();
            patient2.setName("Bob Williams");
            patient2.setContactInfo("bob@example.com");

            session.persist(patient1);
            session.persist(patient2);

            TherapyPrograms program1 = new TherapyPrograms();
            program1.setProgramId("P001");
            program1.setName("Back Pain Relief");
            program1.setDuration("4 Weeks");
            program1.setFee(200.00);

            TherapyPrograms program2 = new TherapyPrograms();
            program2.setProgramId("P002");
            program2.setName("Mental Health Therapy");
            program2.setDuration("6 Weeks");
            program2.setFee(350.00);

            session.persist(program1);
            session.persist(program2);

            TherapySessions session1 = new TherapySessions();
            session1.setDate("2025-03-20");
            session1.setTime("10:00 AM");
            session1.setTherapist(therapist1);
            session1.setPatient(patient1);
            session1.setTherapyProgram(program1);

            TherapySessions session2 = new TherapySessions();
            session2.setDate("2025-03-22");
            session2.setTime("2:00 PM");
            session2.setTherapist(therapist2);
            session2.setPatient(patient2);
            session2.setTherapyProgram(program2);

            session.persist(session1);
            session.persist(session2);

            Payments payment1 = new Payments();
            payment1.setAmount(200.00);
            payment1.setDate("2025-03-21");
            payment1.setPatient(patient1);
            payment1.setTherapySession(session1);

            Payments payment2 = new Payments();
            payment2.setAmount(350.00);
            payment2.setDate("2025-03-23");
            payment2.setPatient(patient2);
            payment2.setTherapySession(session2);

            session.persist(payment1);
            session.persist(payment2);

            transaction.commit();
            System.out.println("Sample data inserted successfully!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}