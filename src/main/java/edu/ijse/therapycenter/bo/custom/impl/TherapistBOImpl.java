package edu.ijse.therapycenter.bo.custom.impl;

import edu.ijse.therapycenter.bo.custom.TherapistBO;
import edu.ijse.therapycenter.dto.TherapistDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TherapistBOImpl implements TherapistBO {
    @Override
    public boolean save(TherapistDTO therapist) {
        return false;
    }

    @Override
    public boolean update(TherapistDTO therapist) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<TherapistDTO> getAll() {
        return List.of();
    }

    @Override
    public Optional<TherapistDTO> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
