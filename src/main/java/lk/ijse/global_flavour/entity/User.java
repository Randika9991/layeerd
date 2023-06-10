package lk.ijse.global_flavour.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class User {
    private String userName;
    private String empId;
    private String password;
    private String email;
    private String jobTitle;
}
