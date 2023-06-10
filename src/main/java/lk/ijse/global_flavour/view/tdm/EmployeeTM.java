package lk.ijse.global_flavour.view.tdm;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeTM {
    private String employeeId;
    private String employeeName;
    private String Address;
    private String dob;
    private String cotactNo;
    private String email;
    private String nic;
    private String jobTittle;

    public EmployeeTM(String string) {
        this.employeeId=string;
    }


}
