package lk.ijse.global_flavour.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    private String itemCode;
    private String itemName;
    private Double unitPrice;
    private String category;
    private Integer qtyOnHand;
}
