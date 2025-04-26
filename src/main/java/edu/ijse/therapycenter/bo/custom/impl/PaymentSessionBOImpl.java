package edu.ijse.therapycenter.bo.custom.impl;

import edu.ijse.therapycenter.bo.custom.PaymentSessionBO;
import edu.ijse.therapycenter.config.FactoryConfiguration;
import edu.ijse.therapycenter.dao.DAOFactory;
import edu.ijse.therapycenter.dao.custom.impl.PaymentDAOImpl;
import edu.ijse.therapycenter.dao.custom.impl.TherapySessionDAOImpl;
import edu.ijse.therapycenter.dto.*;
import edu.ijse.therapycenter.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentSessionBOImpl implements PaymentSessionBO {

    private final PaymentDAOImpl paymentDAO = (PaymentDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PAYMENT);
    private final TherapySessionDAOImpl therapySessionDAO = (TherapySessionDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_SESSION);

    @Override
    public void saveSession(TherapySessionDTO therapySessionDTO, PaymentDTO paymentDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            TherapySession therapySession = therapyToEntity(therapySessionDTO);
            Payment payment = paymentToEntity(paymentDTO);

            boolean therapySaved = therapySessionDAO.save(therapySession);
            if (!therapySaved) {
                transaction.rollback();
                return;
            }

            boolean paymentSaved = paymentDAO.save(payment);
            if (!paymentSaved) {
                transaction.rollback();
                return;
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateSession(String sessionId, String paymentId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {


            boolean therapySaved = therapySessionDAO.completeTherapy(sessionId);
            if (!therapySaved) {
                transaction.rollback();
                return;
            }

            boolean paymentSaved = paymentDAO.completePayment(paymentId);
            if (!paymentSaved) {
                transaction.rollback();
                return;
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public static TherapySession therapyToEntity(TherapySessionDTO dto) {
        if (dto == null) return null;

        TherapySession entity = new TherapySession();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setTime(dto.getTime());
        entity.setStatus(dto.getStatus());

        entity.setTherapist(dto.getTherapist() != null ? new Therapist(
                dto.getTherapist().getId(),
                dto.getTherapist().getName(),
                dto.getTherapist().getSpecialization(),
                null
        ) : null);

        entity.setPatient(dto.getPatient() != null ? new Patient(
                dto.getPatient().getId(),
                dto.getPatient().getName(),
                dto.getPatient().getContactInfo(),
                dto.getPatient().getGender(),
                dto.getPatient().getBirthDate(),
                null
        ) : null);

        entity.setTherapyProgram(dto.getTherapyProgram() != null ? new TherapyProgram(
                dto.getTherapyProgram().getProgramId(),
                dto.getTherapyProgram().getName(),
                dto.getTherapyProgram().getDuration(),
                dto.getTherapyProgram().getFee(),
                null
        ) : null);

        return entity;
    }

    public static Payment paymentToEntity(PaymentDTO dto) {
        if (dto == null) return null;

        Patient patient = new Patient();
        patient.setId(dto.getPatient().getId());

        TherapySession session = new TherapySession();
        session.setId(dto.getTherapySession().getId());

        return new Payment(
                dto.getId(),
                dto.getAmount(),
                dto.getDate(),
                dto.getStatus(),
                patient,
                session
        );
    }

}
