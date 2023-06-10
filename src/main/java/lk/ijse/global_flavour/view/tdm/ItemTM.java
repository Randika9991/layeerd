package lk.ijse.global_flavour.view.tdm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ItemTM {
    private String itemCode;
    private String itemName;
    private Double unitPrice;
    private String category;
    private Integer Qty;
}
