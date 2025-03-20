package edu.ijse.therapycenter.bo.custom.impl;

import edu.ijse.therapycenter.bo.custom.TherapyProgramBO;
import edu.ijse.therapycenter.dto.TherapyProgramDTO;
import edu.ijse.therapycenter.entity.TherapyProgram;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TherapyProgramBOImpl implements TherapyProgramBO {

    @Override
    public boolean save(TherapyProgramDTO therapyProgram) {
        return false;
    }

    @Override
    public boolean update(TherapyProgramDTO therapyProgram) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<TherapyProgramDTO> getAll() {
        return List.of();
    }

    @Override
    public Optional<TherapyProgramDTO> findByPK(String pk) {
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
