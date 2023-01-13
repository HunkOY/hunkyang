package com.pagoda.util;

import com.pagoda.entity.WmsBill;
import com.pagoda.entity.WmsBillItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hunkyang
 */
public class StreamUtilTest {

    /**
     * 处理
     * @param list
     * @return
     */
    public static Map flatMapTest(List<WmsBillItem> list) {
        /*List<WmsBill> wmsBillList = list.stream().flatMap(x ->
                x.getWms_waybill_goods_items().stream().
                        map(y -> new WmsBill(x.getBrevity_code(), y.getSpu()))).collect(Collectors.toList());
        wmsBillList.stream().forEach(x->{
            System.out.println("brevity_code: " + x.getBrevity_code() + "|" + "spu: " + x.getSpu());
        });
        Map<String, String> map = wmsBillList.stream().collect(Collectors.toMap(WmsBill::getSpu, WmsBill::getBrevity_code, (key1, key2) -> key1 + "," + key2));*/


        Map<String, String> map = list.stream().flatMap(x ->
                x.getWms_waybill_goods_items().stream().
                        map(y -> new WmsBill(x.getBrevity_code(), y.getSpu()))).
                collect(Collectors.toMap(WmsBill::getSpu, WmsBill::getBrevity_code, (key1, key2) -> key1 + "," + key2));

        map.forEach((k,v)->{
            System.out.println("spu: " + k+ "|" + "brevity_code: " + v);
        });
        return new HashMap();
    }
}
