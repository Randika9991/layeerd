package lk.ijse.global_flavour.dao;

import lk.ijse.global_flavour.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoObjectCreater;

    private DAOFactory() {

    }

    public static DAOFactory getDAOFactory() {
        if (daoObjectCreater == null) {
            daoObjectCreater = new DAOFactory();
        }
        return daoObjectCreater;
    }

    public enum DAOTypes{
        ADMINSALARY,CASHIERCUSTOMER,CASHIERVEHICLE,DELIVERY,EMPLOYEE,ITEM,ORDER,ORDERDETAIL,SUPPLIER,SUPPLYLOAD,USER,QUARY
    }

    public <T extends SuperDAO>T getDAO(DAOTypes res) {
        switch (res){
            case ADMINSALARY:
                return (T) new AdminSalaryDAOImpl();
            case CASHIERCUSTOMER:
                return (T) new CashierCustomerDAOImpl();
            case CASHIERVEHICLE:
                return (T) new CashierVehicleDAOImpl();
            case DELIVERY:
                return (T) new DeliveryDAOImpl();
            case EMPLOYEE:
                return (T) new EmployeeDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case ORDER:
                return (T) new OrderFormDAOImpl();
            case ORDERDETAIL:
                return (T) new OrderDetailDAOImpl();
            case SUPPLIER:
                return (T) new SuppliersDAOImpl();
            case SUPPLYLOAD:
                return (T) new SupplyloadFormDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            case QUARY:
                return (T) new QuaryDAOImpl();
            default:
                return null;
        }
    }
}
