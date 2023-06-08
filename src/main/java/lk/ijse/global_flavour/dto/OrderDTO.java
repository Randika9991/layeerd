package lk.ijse.global_flavour.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderDTO {
    String oId;
    String cId;
    double payment;
    LocalDate date;
    LocalTime time;
    OrderCartDTO dto;
    boolean delivery;

}
