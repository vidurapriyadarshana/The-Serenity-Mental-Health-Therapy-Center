package edu.ijse.therapycenter.bo.custom;

import edu.ijse.therapycenter.bo.SuperBO;
import edu.ijse.therapycenter.dto.TherapistDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TherapistBO extends SuperBO {
    boolean save(TherapistDTO therapist);
    boolean update(TherapistDTO therapist);
    boolean deleteByPK(String pk) throws Exception;
    List<TherapistDTO> getAll();
    Optional<TherapistDTO> findByPK(String pk);
    Optional<String> getLastPK();
    boolean exist(String id) throws SQLException, ClassNotFoundException;
    ArrayList<String> therapistList();
    TherapistDTO getAllTherapist(String therapistName);
}
