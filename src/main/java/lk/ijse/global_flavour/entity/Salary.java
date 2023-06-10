package lk.ijse.global_flavour.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Salary {
    private String salaryId;
    private String empId;
    private String amount;
    private String paymentmethod;
}
