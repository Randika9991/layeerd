package lk.ijse.global_flavour.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail {
    private String orderId;
    private String itemCode;
    private Integer qty;
    private Double unitPrice;
}
