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
public class WmsBillItem {


    /**
     * basket_code : 05W012209130035#208126#0002
     * brevity_code : 22002
     * basket_serial : 6
     * status : 0
     * route_info : 01_234
     * wms_waybill_goods_items : [{"spu":"619548","quantity":1},{"spu":"619560","quantity":1}]
     */

//    private String basket_code;
    private String brevity_code;
//    private String basket_serial;
//    private int status;
//    private String route_info;
    private List<WmsWaybillGoodsItemsBean> wms_waybill_goods_items;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WmsWaybillGoodsItemsBean  {
        /**
         * spu : 619548
         * quantity : 1
         */

        private String spu;
//        private int quantity;

    }
}
