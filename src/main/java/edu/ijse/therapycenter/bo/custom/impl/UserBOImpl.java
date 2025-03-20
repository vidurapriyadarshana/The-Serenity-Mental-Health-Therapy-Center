package edu.ijse.therapycenter.bo.custom.impl;

import edu.ijse.therapycenter.bo.custom.UserBO;
import edu.ijse.therapycenter.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserBOImpl implements UserBO {
    @Override
    public boolean save(UserDTO user) {
        return false;
    }

    @Override
    public boolean update(UserDTO user) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<UserDTO> getAll() {
        return List.of();
    }

    @Override
    public Optional<UserDTO> findByPK(String pk) {
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
