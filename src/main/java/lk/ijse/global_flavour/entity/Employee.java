package lk.ijse.global_flavour.entity;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Employee {
    private String empId;
    private String empName;
    private String address;
    private String dob;
    private String contactNo;
    private String email;
    private String nic;
    private String jobTitle;
}
