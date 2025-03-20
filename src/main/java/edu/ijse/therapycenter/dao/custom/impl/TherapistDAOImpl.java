package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.dao.custom.TherapistDAO;
import edu.ijse.therapycenter.entity.Therapist;

import java.util.List;
import java.util.Optional;

public class TherapistDAOImpl implements TherapistDAO {
    @Override
    public boolean save(Therapist therapist) {
        return false;
    }

    @Override
    public boolean update(Therapist therapist) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<Therapist> getAll() {
        return List.of();
    }

    @Override
    public Optional<Therapist> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
