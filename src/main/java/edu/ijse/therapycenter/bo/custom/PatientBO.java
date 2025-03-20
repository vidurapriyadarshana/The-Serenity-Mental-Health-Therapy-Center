package edu.ijse.therapycenter.bo.custom;

import edu.ijse.therapycenter.bo.SuperBO;
import edu.ijse.therapycenter.dto.PatientDTO;
import edu.ijse.therapycenter.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientBO extends SuperBO {
    boolean save(PatientDTO patient);
    boolean update(PatientDTO patient);
    boolean deleteByPK(String pk) throws Exception;
    List<PatientDTO> getAll();
    Optional<PatientDTO> findByPK(String pk);
    Optional<String> getLastPK();
}
