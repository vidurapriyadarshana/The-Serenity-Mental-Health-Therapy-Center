package edu.ijse.therapycenter.bo.custom.impl;

import edu.ijse.therapycenter.bo.custom.TherapySessionBO;
import edu.ijse.therapycenter.dto.TherapySessionDTO;
import edu.ijse.therapycenter.entity.TherapySession;

import java.util.List;
import java.util.Optional;

public class TherapySessionBOImpl implements TherapySessionBO {


    @Override
    public boolean save(TherapySessionDTO therapySession) {
        return false;
    }

    @Override
    public boolean update(TherapySessionDTO therapySession) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<TherapySessionDTO> getAll() {
        return List.of();
    }

    @Override
    public Optional<TherapySessionDTO> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
