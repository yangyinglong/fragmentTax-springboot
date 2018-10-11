package com.leshuibao.fragmentTax.logicalModel;

import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.OrderReqDto;
import com.leshuibao.fragmentTax.dto.request.RegisterReqDto;
import com.leshuibao.fragmentTax.dto.response.UserRespDto;

import java.util.List;

public interface ITradingHallLogical {


    void addOrderEntity(OrderEntity orderEntity);

    void addPayerEntty(PayerEntity payerEntity);

    void addAddressEntty(AddressEntity addressEntity);

    void addShoppingTrolley(ShoppingTrolleyEntity shoppingTrolleyEntitie);

    void addPaymentEntity(PaymentEntity paymentEntity);

    void addPayeeEntity(PayeeEntity payeeEntity);

    void addInvoiceDeliveryEntity(InvoiceDeliveryEntity invoiceDeliveryEntity);
}
