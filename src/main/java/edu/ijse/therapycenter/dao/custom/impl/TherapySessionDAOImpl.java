package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.dao.custom.TherapySessionDAO;
import edu.ijse.therapycenter.entity.Patient;
import edu.ijse.therapycenter.entity.Therapist;
import edu.ijse.therapycenter.entity.TherapyProgram;
import edu.ijse.therapycenter.entity.TherapySession;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import edu.ijse.therapycenter.config.FactoryConfiguration;
import org.hibernate.Transaction;

public class TherapySessionDAOImpl implements TherapySessionDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(TherapySession therapySession) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();

            Therapist therapist = session.get(Therapist.class, therapySession.getTherapist().getId());
            Patient patient = session.get(Patient.class, therapySession.getPatient().getId());
            TherapyProgram program = session.get(TherapyProgram.class, therapySession.getTherapyProgram().getProgramId());

            if (therapist == null || patient == null || program == null) {
                System.out.println("Referenced entities do not exist.");
                transaction.rollback();
                return false;
            }

            session.createNativeQuery(
                            "INSERT INTO therapy_sessions (id, date, time, status, therapist_id, patient_id, program_id) " +
                                    "VALUES (:id, :date, :time, :status, :therapistId, :patientId, :programId)")
                    .setParameter("id", therapySession.getId())
                    .setParameter("date", therapySession.getDate())
                    .setParameter("time", therapySession.getTime())
                    .setParameter("status", therapySession.getStatus())
                    .setParameter("therapistId", therapist.getId())
                    .setParameter("patientId", patient.getId())
                    .setParameter("programId", program.getProgramId())
                    .executeUpdate();

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(TherapySession therapySession) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<TherapySession> getAll() {
        return List.of();
    }

    @Override
    public Optional<TherapySession> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        Session session = null;
        try {
            session = factoryConfiguration.getSession();
            Long lastPk = session
                    .createQuery("SELECT p.id FROM TherapySession p ORDER BY p.id DESC", Long.class)
                    .setMaxResults(1)
                    .uniqueResult();

            Long newPk = (lastPk != null) ? lastPk + 1 : 1;

            System.out.println(newPk);

            return Optional.of(String.valueOf(newPk));

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
