package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.dao.custom.PatientDAO;
import edu.ijse.therapycenter.entity.Patient;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public boolean save(Patient patient) {
        return false;
    }

    @Override
    public boolean update(Patient patient) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<Patient> getAll() {
        return List.of();
    }

    @Override
    public Optional<Patient> findByPK(String pk) {
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
