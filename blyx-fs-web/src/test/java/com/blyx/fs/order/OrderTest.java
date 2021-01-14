package com.blyx.fs.order;

import com.blyx.fs.BaseTest;
import com.blyx.fs.domain.order.ability.OrderAbility;
import com.blyx.fs.domain.order.model.OrderMO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/14
 */
public class OrderTest extends BaseTest {

    @Autowired
    private OrderAbility orderAbility;

    @Test
    public void saveOrder(){
        OrderMO order=new OrderMO();

        order.setOrderCode("BJ12321321321");
        order.setType(1);
        order.setUserName("quyang");
        order.setUserMobile("13718699660");
        order.setOrderProvinceCode(1);
        order.setOrderCityCode(2);
        order.setOrderAreaCode(3);
        order.setOrderProvinceName("北京");
        order.setOrderCityName("万荣");
        order.setOrderAreaName("guanghua");
        order.setOrderAddressDetail("详细信息");
        order.setStatus(1);
        order.setWorkerPin("12321321321");
        order.setSumAmount(10000);
        order.setWorkerAmount(200000);
        order.setServiceCharge(900);
        order.setContext("321321312");
        order.setWorkerMark("fdsafdsa");
        order.setRepairRegion("fdsafdsaf");
        order.setStartTime(new Date());
        order.setEndTime(new Date());
        order.setScore(199900);
        order.setUserEvaluation("挺好的");
        order.setErrorCode(1000);
        order.setErrorMsg("fdasfdsa");

        Integer count=orderAbility.createOneOrder(order);
        System.out.println(count);

    }
}
