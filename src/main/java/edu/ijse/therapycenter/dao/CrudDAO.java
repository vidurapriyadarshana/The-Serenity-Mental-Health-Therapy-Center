package edu.ijse.therapycenter.dao;

import edu.ijse.therapycenter.entity.SuperEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {

    boolean save(T t);
    boolean update(T t);
    boolean deleteByPK(ID pk) throws Exception;
    List<T> getAll();
    Optional<T> findByPK(ID pk);
    Optional<String> getLastPK();
    boolean exist(String id) throws SQLException, ClassNotFoundException;

}
