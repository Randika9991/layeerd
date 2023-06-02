package lk.ijse.global_flavour.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UserCreateAcount {

    private String name;
    private String password;
    private String email;
    private String jobTitle;
}
