package com.leshuibao.fragmentTax.controller.front;


import com.leshuibao.fragmentTax.dao.entity.ShoppingTrolleyEntity;
import com.leshuibao.fragmentTax.dto.request.InvoiceDeliveryReqDto;
import com.leshuibao.fragmentTax.dto.request.OrderReqDto;
import com.leshuibao.fragmentTax.dto.request.PayeeDto;
import com.leshuibao.fragmentTax.dto.request.PaymentDto;
import com.leshuibao.fragmentTax.logicalModel.ITradingHallLogical;
import com.leshuibao.fragmentTax.util.UUIDUtil;
import com.leshuibao.fragmentTax.viewModel.ITradingHallView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Path("/tradingHall")
@CrossOrigin
public class TradingHallAddController {

    @Autowired
    private ITradingHallView tradingHallView;

    @Autowired
    private ITradingHallLogical tradingHallLogical;

    @Path("/addOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addOrder(OrderReqDto orderReqDto) {

        Map<String, Object> resp = new HashMap<>();

        String orderKey = UUIDUtil.UString(24);
        String payerKey = UUIDUtil.UString(24);
        String addressKey = UUIDUtil.UString(24);

        try {
            tradingHallLogical.addOrderEntity(tradingHallView.getOrderEntity(orderKey, payerKey, addressKey, orderReqDto));
            tradingHallLogical.addPayerEntty(tradingHallView.getPayerEntity(payerKey, orderReqDto));
            tradingHallLogical.addAddressEntty(tradingHallView.getAddressEntity(addressKey, payerKey, orderReqDto));
            List<ShoppingTrolleyEntity> shoppingTrolleyEntities = tradingHallView.getShoppingTrolleyEntitys(orderKey, orderReqDto);
            for (ShoppingTrolleyEntity shoppingTrolleyEntitie : shoppingTrolleyEntities) {
                tradingHallLogical.addShoppingTrolley(shoppingTrolleyEntitie);
            }

            resp.put("c", 200);
            resp.put("r", orderKey);

            return resp;
        } catch (Exception e) {
            System.err.println(e);
        }

        resp.put("c", 400);
        resp.put("r", "失败");

        return resp;
    }

    @Path("/addPayment")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addPayment(PaymentDto paymentDto) {

        Map<String, Object> resp = new HashMap<>();

        try {
            tradingHallLogical.addPaymentEntity(tradingHallView.getPaymentEntity(paymentDto));

            resp.put("c", 200);
            resp.put("r", "1");
        } catch (Exception e) {
            System.err.println(e);
        }
        resp.put("c", 400);
        resp.put("r", "付款记录存储失败");
        return resp;
    }

    @Path("/addPayee")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addPayee(PayeeDto payeeDto) {

        Map<String, Object> resp = new HashMap<>();
        try {
            tradingHallLogical.addPayeeEntity(tradingHallView.getPayeeEntity(payeeDto));

            resp.put("c", 200);
            resp.put("r", "增加开票人信息成功");
            return resp;
        } catch (Exception e) {
            System.err.println(e);
        }
        resp.put("c", 400);
        resp.put("r", "增加开票人信息失败");
        return resp;
    }

    @Path("/addInvoicedelivery")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addInvoicedelivery(InvoiceDeliveryReqDto invoiceDeliveryReqDto) {

        Map<String, Object> resp = new HashMap<>();

        String orderKey = UUIDUtil.UString(24); // act as invoiceDelivery id
        String addressKey = UUIDUtil.UString(24);
        try {
            tradingHallLogical.addInvoiceDeliveryEntity(tradingHallView.getInvoiceDeliveryEntity(orderKey, addressKey, invoiceDeliveryReqDto));
            tradingHallLogical.addAddressEntty(tradingHallView.getAddressEntity(addressKey, invoiceDeliveryReqDto));

            resp.put("c", 200);
            resp.put("r", "保存发票邮寄申请信息成功");
            return resp;
        } catch (Exception e) {
            resp.put("c", 400);
            resp.put("r", "保存发票邮寄申请信息失败");
            return resp;
        }
    }
}
