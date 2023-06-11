package lk.ijse.global_flavour.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SupplyLoadDetail {
    private String loadId;
    private String itemCode;
    private String supId;
    private LocalDate date;
    private Double price;
    private Integer qty;
    private LocalTime time;

    /*public SupplyLoadDetail(String itemcode, Integer suppqty) {
        this.itemCode = itemcode;
        this.qty = suppqty;
    }*/
}
