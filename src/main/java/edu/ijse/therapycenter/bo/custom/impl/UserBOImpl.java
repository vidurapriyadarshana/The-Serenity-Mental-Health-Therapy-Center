package edu.ijse.therapycenter.bo.custom.impl;

import edu.ijse.therapycenter.bo.custom.UserBO;
import edu.ijse.therapycenter.dao.DAOFactory;
import edu.ijse.therapycenter.dao.custom.impl.UserDAOImpl;
import edu.ijse.therapycenter.dto.UserDTO;
import edu.ijse.therapycenter.entity.User;
import edu.ijse.therapycenter.util.PasswordUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserBOImpl implements UserBO {

    private final UserDAOImpl userDAO = (UserDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.USER);

    @Override
    public boolean save(UserDTO user) {
        User userEntity = toUser(user);
        return userDAO.save(userEntity);
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
        return userDAO.getLastPK();
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    public static UserDTO toUserDTO(User user) {
        String hashedPassword = PasswordUtils.hashPassword(user.getPassword());

        System.out.println("Hashed Password: " + hashedPassword);

        if (user == null) {
            return null;
        }

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                hashedPassword,
                user.getRole()
        );
    }


    public static User toUser(UserDTO userDTO) {
        String hashedPassword = PasswordUtils.hashPassword(userDTO.getPassword());

        System.out.println("Hashed Password: " + hashedPassword);

        if (userDTO == null) {
            return null;
        }
        return new User(
                userDTO.getId(),
                userDTO.getUsername(),
                hashedPassword,
                userDTO.getRole()
        );
    }

}
