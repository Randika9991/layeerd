package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.DeliveryDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDAOImpl implements DeliveryDAO {
    @Override
    public boolean save(Object SalaryAdd) throws SQLException {
        return false;
    }

    @Override
    public ArrayList getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(Object adminSalary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList search(Object salId) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        return false;
    }
}
