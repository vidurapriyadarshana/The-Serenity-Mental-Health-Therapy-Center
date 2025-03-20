package edu.ijse.therapycenter.bo.custom.impl;

import edu.ijse.therapycenter.bo.custom.PatientBO;
import edu.ijse.therapycenter.dto.PatientDTO;

import java.util.List;
import java.util.Optional;

public class PatientBOImpl implements PatientBO {
    @Override
    public boolean save(PatientDTO patient) {
        return false;
    }

    @Override
    public boolean update(PatientDTO patient) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<PatientDTO> getAll() {
        return List.of();
    }

    @Override
    public Optional<PatientDTO> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
