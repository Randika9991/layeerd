package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.SupplyloadFormBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.ItemDAO;
import lk.ijse.global_flavour.dao.custom.SuppliersDAO;
import lk.ijse.global_flavour.dao.custom.SupplyloadFormDAO;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;
import lk.ijse.global_flavour.dto.SuppliersDTO;
import lk.ijse.global_flavour.entity.Item;
import lk.ijse.global_flavour.entity.Supplier;
import lk.ijse.global_flavour.entity.SupplyLoadDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SupplyloadFormBOImpl implements SupplyloadFormBO {



    SuppliersDAO suppliersDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    SupplyloadFormDAO supplyFormDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLYLOAD);

    public ArrayList<SuppliersDTO> getAllSuppliers() throws SQLException{
        ArrayList<Supplier> arrayList = suppliersDAO.getAll();
        ArrayList<SuppliersDTO> dtoArrayList = new ArrayList<>();
        for (Supplier suppliers: arrayList) {
            dtoArrayList.add(new SuppliersDTO(suppliers.getSupId(),suppliers.getSupName(),suppliers.getAddress(),suppliers.getEmail(),suppliers.getContactNo()));
        }
        return dtoArrayList;
    }

    public String getSupplierName(String supp_id) throws SQLException{
        return suppliersDAO.getSupplierName(supp_id);
    }

    public ArrayList<ItemDTO> getAllItem() throws SQLException{
        ArrayList<Item> arrayList = itemDAO.getAll();
        ArrayList<ItemDTO> dtoArrayList = new ArrayList<>();

        for (Item item : arrayList) {
            dtoArrayList.add(new ItemDTO(item.getItemCode(),item.getItemName(),
                    item.getUnitPrice(),item.getCategory(),item.getQtyOnHand()));
        }
        return dtoArrayList;
    }

    public ArrayList<ItemDTO> searchItem(String id) throws SQLException{
        ArrayList<Item> arrayList = itemDAO.search(id);
        ArrayList<ItemDTO> dtoArrayList = new ArrayList<>();

        for (Item item : arrayList) {
            dtoArrayList.add(new ItemDTO(item.getItemCode(),item.getItemName(),
                    item.getUnitPrice(),item.getCategory(),item.getQtyOnHand()));
        }
        return dtoArrayList;
    }

    public String getNextSupplyLoadId() throws SQLException{
        return supplyFormDAO.getNextSupplyLoadId();
    }

    public boolean placeLoad(String loadid, String suppid, Double totalprice, List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException {

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            for (PlaceSupplyLoadDTO p : placeSupplyLoadDTOList){

                boolean isSaved = supplyFormDAO.save(new SupplyLoadDetail(loadid,p.getItemcode(),suppid,LocalDate.now(),totalprice,p.getSuppqty(), LocalTime.now()));

                if(isSaved) {
                    System.out.println("saved");
                    boolean isUpdated = itemDAO.addQty(placeSupplyLoadDTOList);
                    if(isUpdated) {
                        System.out.println("updated");
                        con.commit();                                                                                                                                                 //database ekata save eka
                        return true;
                    }
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
