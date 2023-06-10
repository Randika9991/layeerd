package lk.ijse.global_flavour.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String custId;
    private String custName;
    private String contactNo;
    private String address;
    private String email;
}
