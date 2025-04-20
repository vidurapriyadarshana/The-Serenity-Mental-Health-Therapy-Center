package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.config.FactoryConfiguration;
import edu.ijse.therapycenter.dao.custom.PatientDAO;
import edu.ijse.therapycenter.dto.PatientDTO;
import edu.ijse.therapycenter.entity.Patient;
import edu.ijse.therapycenter.entity.Therapist;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(Patient patient) {
        Transaction transaction = null;

        try (Session session = factoryConfiguration.getSession()) {
            transaction = session.beginTransaction();

            session.persist(patient);

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Patient patient) {
        Transaction transaction = null;

        try (Session session = factoryConfiguration.getSession()) {
            transaction = session.beginTransaction();

            session.merge (patient);

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteByPK(String pk) throws Exception {
        Transaction transaction = null;

        try (Session session = factoryConfiguration.getSession()) {
            transaction = session.beginTransaction();

            Patient patient = session.get(Patient.class, pk);
            if (patient != null) {
                session.remove(patient);
            } else {
                return false;
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Patient> getAll() {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("FROM Patient", Patient.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    @Override
    public Optional<Patient> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        Session session = null;
        try {
            session = factoryConfiguration.getSession();
            Long lastPk = session
                    .createQuery("SELECT p.id FROM Patient p ORDER BY p.id DESC", Long.class)
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

    @Override
    public ArrayList<String> patientList() {
        ArrayList<String> patientsNames = new ArrayList<>();

        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            List<String> names = session.createQuery("SELECT tp.name FROM Patient tp", String.class).list();
            patientsNames.addAll(names);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return patientsNames;
    }

    @Override
    public Patient getAllPatient(String patientName) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery(
                            "FROM Patient WHERE name = :name", Patient.class)
                    .setParameter("name", patientName)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
