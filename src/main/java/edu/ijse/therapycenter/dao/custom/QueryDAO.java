package edu.ijse.therapycenter.dao.custom;

import edu.ijse.therapycenter.dao.SuperDAO;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<String> getPatientDetails(String selectedPatient);
}
