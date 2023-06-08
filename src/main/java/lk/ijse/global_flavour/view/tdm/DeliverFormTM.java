package lk.ijse.global_flavour.view.tdm;

import java.time.LocalDate;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class DeliverFormTM {
    private String deliverId;
    private String empId;
    private String orderId;
    private String vehicalId;
    private String location;
    private LocalDate deliverDate;
    private LocalDate dueDate;
    private String deliverStatus;
}
