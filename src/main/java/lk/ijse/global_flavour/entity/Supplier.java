package lk.ijse.global_flavour.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Supplier {
    private String supId;
    private String supName;
    private String address;
    private String email;
    private String contactNo;
}
