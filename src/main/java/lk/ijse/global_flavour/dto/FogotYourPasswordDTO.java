package lk.ijse.global_flavour.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class FogotYourPasswordDTO {
    private String usrname;
    private String empid;
    private String password;
    private String email;
    private String jobtitel;
}
