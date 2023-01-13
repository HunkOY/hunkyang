package com.pagoda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author hunkyang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WmsBill {


    /**
     * basket_code : 05W012209130035#208126#0002
     * brevity_code : 22002
     * basket_serial : 6
     * status : 0
     * route_info : 01_234
     * wms_waybill_goods_items : [{"spu":"619548","quantity":1},{"spu":"619560","quantity":1}]
     */


    private String brevity_code;
    private String spu;

}
