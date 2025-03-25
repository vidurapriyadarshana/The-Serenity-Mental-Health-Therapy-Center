package edu.ijse.therapycenter.dao.custom.impl;

import edu.ijse.therapycenter.config.FactoryConfiguration;
import edu.ijse.therapycenter.dao.custom.TherapyProgramDAO;
import edu.ijse.therapycenter.entity.TherapyProgram;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TherapyProgramDAOImpl implements TherapyProgramDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

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
        Session session = null;
        try {
            session = factoryConfiguration.getSession();
            String lastPk = session
                    .createQuery("SELECT t.id FROM TherapyProgram t ORDER BY t.id DESC", String.class)
                    .setMaxResults(1)
                    .uniqueResult();

            if (lastPk != null && lastPk.matches("MT\\d+")) {
                int lastNumber = Integer.parseInt(lastPk.substring(2));
                int newNumber = lastNumber + 1;
                String newPk = String.format("MT%04d", newNumber);
                return Optional.of(newPk);
            } else {
                return Optional.of("MT1001");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
