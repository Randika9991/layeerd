package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.SuppliersDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SuppliersDAO extends CrudDAO<SuppliersDTO,String> {

     String getSupplierName(String supp_id) throws SQLException ;
}
