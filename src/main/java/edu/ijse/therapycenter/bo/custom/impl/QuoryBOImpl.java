package edu.ijse.therapycenter.bo.custom.impl;

import edu.ijse.therapycenter.bo.custom.QuoryBO;
import edu.ijse.therapycenter.dao.DAOFactory;
import edu.ijse.therapycenter.dao.custom.impl.QueryDAOImpl;

import java.util.ArrayList;

public class QuoryBOImpl implements QuoryBO {

    private final QueryDAOImpl queryDAO = (QueryDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QUERY);

    @Override
    public ArrayList<String> getPatientDetails(String selectedPatient) {
        return queryDAO.getPatientDetails(selectedPatient);
    }
}
