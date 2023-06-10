package lk.ijse.global_flavour.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeDTO {

    public EmployeeDTO(String employeeId) {
        this.employeeId = employeeId;
    }

    private String employeeId;
    private String employeeName;
    private String Address;
    private String DOB;
    private String cotactNo;
    private String email;
    private String nic;
    private String jobTittle;




}
