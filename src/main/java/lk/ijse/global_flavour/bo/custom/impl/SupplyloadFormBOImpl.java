package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.SupplyloadFormBO;
import lk.ijse.global_flavour.dao.custom.ItemDAO;
import lk.ijse.global_flavour.dao.custom.SuppliersDAO;
import lk.ijse.global_flavour.dao.custom.SupplyloadFormDAO;
import lk.ijse.global_flavour.dao.custom.impl.ItemDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.SuppliersDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.SupplyloadFormDAOImpl;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;
import lk.ijse.global_flavour.dto.SuppliersDTO;
//import lk.ijse.global_flavour.model.ItemModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SupplyloadFormBOImpl implements SupplyloadFormBO {



    SuppliersDAO suppliersDAO = new SuppliersDAOImpl();
    ItemDAO itemDAO = new ItemDAOImpl();
    SupplyloadFormDAO supplyFormDAO = new SupplyloadFormDAOImpl();

    public ArrayList<SuppliersDTO> getAllSuppliers() throws SQLException{
        return suppliersDAO.getAll();
    }

    public String getSupplierName(String supp_id) throws SQLException{
        return suppliersDAO.getSupplierName(supp_id);
    }

    public ArrayList<ItemDTO> getAllItem() throws SQLException{
        return itemDAO.getAll();
    }

    public ArrayList<ItemDTO> searchItem(String salId) throws SQLException{
        return itemDAO.search(salId);
    }

    public String getNextSupplyLoadId() throws SQLException{
        return supplyFormDAO.getNextSupplyLoadId();
    }

    public boolean placeLoad(String loadid, String suppid, String totalprice, List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException {

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isSaved = supplyFormDAO.saveloadDetail(loadid,suppid,totalprice, LocalDate.now(), LocalTime.now(), placeSupplyLoadDTOList);
            if(isSaved) {
                System.out.println("saved");
                boolean isUpdated = itemDAO.addQty(placeSupplyLoadDTOList);
                if(isUpdated) {
                    System.out.println("updated");
                    con.commit();                                                                                                                                                 //database ekata save eka
                    return true;
                }
            }
            return false;
        } catch (SQLException er) {
            System.out.println(er);
            con.rollback();
            return false;
        } finally {
            System.out.println("finally");
            con.setAutoCommit(true);
        }
    }



}
