package lk.ijse.global_flavour.bo;

import lk.ijse.global_flavour.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boObjectCreater;

    private BOFactory() {

    }

    public static BOFactory getBOFactory() {
        if (boObjectCreater==null) {
            boObjectCreater = new BOFactory();
        }
        return boObjectCreater;
    }

    public enum BOType{
        ADMIN_SALARY,CASHIER_CUSTOMER,CASHIER_VEHICLE,CHANGE_PASSWORD,CREATE_NEW_ACCOUNT,DELIVERY,DELIVERY_FORM,EMPLOYEE,ITEM,LOGIN_PAGE,ORDER_FORM,SUPPLIER,SUPPLY_LOAD,HOME
    }

    public <T extends SuperBO>T getBO(BOType rest) {
        switch (rest) {
            case ADMIN_SALARY:
                return (T) new AdminSalaryBOImpl();
            case CASHIER_CUSTOMER:
                return (T) new CashierCustomerBOImpl();
            case CASHIER_VEHICLE:
                return (T) new CashierVehicleBOImpl();
            case CHANGE_PASSWORD:
                return (T) new ChangePasswordBOImpl();
            case CREATE_NEW_ACCOUNT:
                return (T) new CreateNewAccountBOImpl();
            case DELIVERY:
                return (T) new DeliveryBOImpl();
            case DELIVERY_FORM:
                return (T) new DeliveryFormBOImpl();
            case EMPLOYEE:
                return (T) new EmployeeBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            case LOGIN_PAGE:
                return (T) new LoginPageBOImpl();
            case ORDER_FORM:
                return (T) new OrderFormBOImpl();
            case SUPPLIER:
                return (T) new SuppliersBOImpl();
            case SUPPLY_LOAD:
                return (T) new SupplyloadFormBOImpl();
            case HOME:
                return (T) new HomeBOImpl();
            default:
                return null;
        }
    }
}

