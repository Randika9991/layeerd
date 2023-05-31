package lk.ijse.global_flavour.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdminSalaryDTO {
    private String salaryId;
    private String employId;
    private String amount;
    private String payment;
}
