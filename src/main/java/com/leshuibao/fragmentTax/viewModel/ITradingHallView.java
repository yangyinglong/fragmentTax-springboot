package com.leshuibao.fragmentTax.viewModel;

import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.InvoiceDeliveryReqDto;
import com.leshuibao.fragmentTax.dto.request.OrderReqDto;
import com.leshuibao.fragmentTax.dto.request.PayeeDto;
import com.leshuibao.fragmentTax.dto.request.PaymentDto;

import java.util.List;

public interface ITradingHallView {

    OrderEntity getOrderEntity(String key, String payerKey, String orderKey, OrderReqDto orderReqDto);

    PayerEntity getPayerEntity(String payerKey, OrderReqDto orderReqDto);

    AddressEntity getAddressEntity(String addressKey,String payerKey, OrderReqDto orderReqDto);

    AddressEntity getAddressEntity(String addressKey, InvoiceDeliveryReqDto invoiceDeliveryReqDto);

    List<ShoppingTrolleyEntity> getShoppingTrolleyEntitys(String orderKey, OrderReqDto orderReqDto);

    PaymentEntity getPaymentEntity(PaymentDto paymentDto);

    PayeeEntity getPayeeEntity(PayeeDto payeeDto);

    InvoiceDeliveryEntity getInvoiceDeliveryEntity(String orderKey, String addressKey, InvoiceDeliveryReqDto invoiceDeliveryReqDto);
}
