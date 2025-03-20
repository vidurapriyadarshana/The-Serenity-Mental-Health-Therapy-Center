package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.dao.custom.TherapySessionDAO;
import edu.ijse.therapycenter.entity.TherapySession;

import java.util.List;
import java.util.Optional;

public class TherapySessionDAOImpl implements TherapySessionDAO {
    @Override
    public boolean save(TherapySession therapySession) {
        return false;
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
        return Optional.empty();
    }
}
