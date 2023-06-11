package lk.ijse.global_flavour.entity;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Delivery {
    private String deliveryId;
    private String empId;
    private String orderId;
    private String vehiId;
    private String location;
    private LocalDate deliveryDate;
    private LocalDate dueDate;
    private String deliveryStatus;
}
