package edu.ijse.therapycenter.bo.custom;

import edu.ijse.therapycenter.bo.SuperBO;

import java.util.ArrayList;

public interface QuoryBO extends SuperBO {
    ArrayList<String> getPatientDetails(String selectedPatient);
}
