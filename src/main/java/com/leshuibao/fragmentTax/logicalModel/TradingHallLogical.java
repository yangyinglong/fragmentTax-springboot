package com.leshuibao.fragmentTax.logicalModel;

import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//todo 1，需要增加插入失败异常处理，2，最好是有返回值，根据返回值判断插入结果
@Service
public class TradingHallLogical implements ITradingHallLogical {

    @Autowired
    IOrderMapper orderMapper;
    @Autowired
    IPayerMapper payerMapper;
    @Autowired
    IAddressMapper addressMapper;
    @Autowired
    IShoppingTrolleyMapper shoppingTrolleyMapper;
    @Autowired
    IPaymentMapper paymentMapper;
    @Autowired
    IPayeeMapper payeeMapper;
    @Autowired
    IInvoiceDeliveryMapper iInvoiceDeliveryMapper;

    @Override
    public void addOrderEntity(OrderEntity orderEntity) {
        orderMapper.insert(orderEntity);
    }

    @Override
    public void addPayerEntty(PayerEntity payerEntity) {
        payerMapper.insert(payerEntity);
    }

    @Override
    public void addAddressEntty(AddressEntity addressEntity) {
        addressMapper.insert(addressEntity);
    }

    @Override
    public void addShoppingTrolley(ShoppingTrolleyEntity shoppingTrolleyEntitie) {
        shoppingTrolleyMapper.insert(shoppingTrolleyEntitie);
    }

    @Override
    public void addPaymentEntity(PaymentEntity paymentEntity) {
        paymentMapper.insert(paymentEntity);
    }

    @Override
    public void addPayeeEntity(PayeeEntity payeeEntity) {
        payeeMapper.insert(payeeEntity);
    }

    @Override
    public void addInvoiceDeliveryEntity(InvoiceDeliveryEntity invoiceDeliveryEntity) {
        iInvoiceDeliveryMapper.insert(invoiceDeliveryEntity);
    }
}
