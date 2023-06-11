package lk.ijse.global_flavour.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Orders {
    private String orderId;
    private String custId;
    private Double payment;
    private LocalTime time;
    private LocalDate date;
    private Boolean deliveryStatus;
}
