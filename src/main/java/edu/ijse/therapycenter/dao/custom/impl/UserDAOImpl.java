package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.config.FactoryConfiguration;
import edu.ijse.therapycenter.dao.custom.UserDAO;
import edu.ijse.therapycenter.entity.User;
import org.hibernate.Session;
import edu.ijse.therapycenter.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

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
        Session session = factoryConfiguration.getSession();

        Long lastPk = session
                .createQuery("SELECT c.id FROM User c ORDER BY c.id DESC", Long.class)
                .setMaxResults(1)
                .uniqueResult();

        return Optional.ofNullable(lastPk).map(String::valueOf);
    }


    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
