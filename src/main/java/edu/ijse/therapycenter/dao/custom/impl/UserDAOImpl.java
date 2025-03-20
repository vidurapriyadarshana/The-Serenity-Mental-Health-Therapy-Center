package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.dao.custom.UserDAO;
import edu.ijse.therapycenter.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public Optional<User> findByPK(String pk) {
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
