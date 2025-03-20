package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.dao.custom.TherapyProgramDAO;
import edu.ijse.therapycenter.entity.TherapyProgram;

import java.util.List;
import java.util.Optional;

public class TherapyProgramDAOImpl implements TherapyProgramDAO {
    @Override
    public boolean save(TherapyProgram therapyProgram) {
        return false;
    }

    @Override
    public boolean update(TherapyProgram therapyProgram) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<TherapyProgram> getAll() {
        return List.of();
    }

    @Override
    public Optional<TherapyProgram> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
