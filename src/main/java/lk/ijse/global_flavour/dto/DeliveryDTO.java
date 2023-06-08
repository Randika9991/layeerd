package lk.ijse.global_flavour.dto;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryDTO {
    private String deliverId;
    private String empId;
    private String orderId;
    private String vehicalId;
    private String location;
    private LocalDate deliverDate;
    private LocalDate dueDate;
    private String deliverStatus;



    public DeliveryDTO(String deliverId, String employeId, String orderId, String vehiId, String location, LocalDate dueDate) {
        this.deliverId = deliverId;
        this.empId = employeId;
        this.orderId = orderId;
        this.vehicalId = vehiId;
        this.location = location;
        this.dueDate = dueDate;
    }


}
