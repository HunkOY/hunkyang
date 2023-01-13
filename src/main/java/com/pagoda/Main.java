package com.pagoda;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.pagoda.entity.WmsBill;
import com.pagoda.entity.WmsBillItem;
import com.pagoda.util.JSONUtil;
import com.pagoda.util.StreamUtilTest;

import java.util.List;

/**
 * @author Hunk
 * @Description TODO
 * @Date 2020/10/29 15:38
 */
public class Main {

    public static void main(String[] args) {

        String json = "{\"new_supply\":\"多2\",\"dsakldjsklajdksla\":111,\"thermosphere\":\"冷\",\"order_tag\":\"早256什么的\",\"cfc_name\":\"这个不知道是什么\",\"source_order_id\":\"124314321543\",\"delivery_dock_name\":\"什么什么站点\",\"batch_strategy\":\"O2O\"}";
        JSONObject jsonObject = JSONUtil.generateString(json);
//        System.out.println(jsonObject);

//        String sign = SignUtil.generateSign("2020-10-29 16:35:57");
//        System.out.println("生成的sign: "+sign);
//        System.out.println(StringUtil.desensitizedCustomerName("我的名字"));
//
//        System.out.println(StringUtil.desensitizedCustomerName("我的名"));
//
//        System.out.println(StringUtil.desensitizedCustomerName("我的"));
//
//        System.out.println(StringUtil.desensitizedCustomerName("我"));

//        Integer a = null;
//        Optional.ofNullable(a).get().longValue();

        //test flatMap
        List<WmsBillItem> list  = Lists.newArrayList();
        WmsBillItem wmsBillItem1 = new WmsBillItem("1",
                Lists.newArrayList(new WmsBillItem.WmsWaybillGoodsItemsBean("2"),
                        new WmsBillItem.WmsWaybillGoodsItemsBean("3")));
        WmsBillItem wmsBillItem2 = new WmsBillItem("2",
                Lists.newArrayList(new WmsBillItem.WmsWaybillGoodsItemsBean("1"),
                        new WmsBillItem.WmsWaybillGoodsItemsBean("3")));
        WmsBillItem wmsBillItem3 = new WmsBillItem("3",
                Lists.newArrayList(new WmsBillItem.WmsWaybillGoodsItemsBean("2")));
        WmsBillItem wmsBillItem4 = new WmsBillItem("4",
                Lists.newArrayList(new WmsBillItem.WmsWaybillGoodsItemsBean("2")));
        list.add(wmsBillItem1);
        list.add(wmsBillItem2);
        list.add(wmsBillItem3);
        list.add(wmsBillItem4);

        StreamUtilTest.flatMapTest(list);
    }
}
