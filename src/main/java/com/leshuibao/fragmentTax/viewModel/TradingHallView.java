package com.leshuibao.fragmentTax.viewModel;

import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.*;
import com.leshuibao.fragmentTax.util.DateUtil;
import com.leshuibao.fragmentTax.util.FormatUtil;
import com.leshuibao.fragmentTax.util.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TradingHallView implements ITradingHallView {

    @Override
    public OrderEntity getOrderEntity(String orderKey, String payerKey, String addressKey, OrderReqDto orderReqDto) {

        OrderEntity orderEntity = new OrderEntity();

        if (!FormatUtil.isEmpty(orderReqDto)) {
            orderEntity.setId(orderKey);
            orderEntity.setTradeName(orderReqDto.getTradeName());
            orderEntity.setTaxRate(orderReqDto.getTaxRate());
            orderEntity.setPayeeId(orderReqDto.getPayeeId());
            orderEntity.setPayerId(payerKey);
            orderEntity.setAddressId(addressKey);
            orderEntity.setExpressCompany(orderReqDto.getExpressCompany());
            orderEntity.setExpressFee(orderReqDto.getExpressFee());
            orderEntity.setTotalTaxAmout(orderReqDto.getTotalTaxAmount());
            orderEntity.setAuditStatus("未审核");
            orderEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return orderEntity;
        }

        return null;
    }

    @Override
    public PayerEntity getPayerEntity(String payerKey, OrderReqDto orderReqDto) {

        PayerEntity payerEntity = new PayerEntity();

        if (!FormatUtil.isEmpty(orderReqDto)) {
            payerEntity.setId(payerKey);
            payerEntity.setPayerCode(orderReqDto.getPayerDto().getPayerCode());
            payerEntity.setPayerName(orderReqDto.getPayerDto().getPayerName());
            payerEntity.setUserId(orderReqDto.getUserId());
            payerEntity.setPayerAddr(orderReqDto.getPayerDto().getPayerAddr());
            payerEntity.setPayerPhone(orderReqDto.getPayerDto().getPayerPhone());
            payerEntity.setPayerBank(orderReqDto.getPayerDto().getPayerBank());
            payerEntity.setPayerBankNo(orderReqDto.getPayerDto().getPayerBankNo());
            payerEntity.setStatus(0);
            payerEntity.setMemo(orderReqDto.getPayerDto().getPayerMemo());
            payerEntity.setCreateTime(DateUtil.getCurrentDatetime());

            return payerEntity;
        }

        return null;
    }


    @Override
    public AddressEntity getAddressEntity(String addressKey, String payerKey, OrderReqDto orderReqDto) {

        AddressEntity addressEntity = new AddressEntity();

        if (!FormatUtil.isEmpty(orderReqDto)) {
            addressEntity.setId(addressKey);
            addressEntity.setAddress(orderReqDto.getAddress());
            addressEntity.setAddresseeId(payerKey);
            addressEntity.setAddresseeType(0);
            addressEntity.setStatus(0);
            addressEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return addressEntity;
        }
        return null;
    }

    @Override
    public AddressEntity getAddressEntity(String addressKey, InvoiceDeliveryReqDto invoiceDeliveryReqDto) {
        AddressEntity addressEntity = new AddressEntity();

        if (!FormatUtil.isEmpty(invoiceDeliveryReqDto)) {
            addressEntity.setId(addressKey);
            addressEntity.setAddress(invoiceDeliveryReqDto.getAddress());
            addressEntity.setAddresseeId(invoiceDeliveryReqDto.getUserId());
            addressEntity.setAddresseeType(1);
            addressEntity.setStatus(0);
            addressEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return addressEntity;
        }
        return null;
    }


    @Override
    public List<ShoppingTrolleyEntity> getShoppingTrolleyEntitys(String orderKey, OrderReqDto orderReqDto) {

        List<ShoppingTrolleyEntity> shoppingTrolleyEntities = new ArrayList<>();
        ShoppingTrolleyEntity shoppingTrolleyEntity = new ShoppingTrolleyEntity();

        if (!FormatUtil.isEmpty(orderReqDto)) {
            for (ShoppingTrolleyDto shoppingTrolleyDto : orderReqDto.getShoppingTrolleyDtos()) {
                shoppingTrolleyEntity.setId(UUIDUtil.UString(24));
                shoppingTrolleyEntity.setOrderId(orderKey);
                shoppingTrolleyEntity.setGoodsName(shoppingTrolleyDto.getGoodsName());
                shoppingTrolleyEntity.setGoodsType(shoppingTrolleyDto.getGoodsTpey());
                shoppingTrolleyEntity.setMeasureUnit(shoppingTrolleyDto.getMeasureUnit());
                shoppingTrolleyEntity.setBuyedNum(shoppingTrolleyDto.getBuyedNum());
                shoppingTrolleyEntity.setPrice(shoppingTrolleyDto.getPrice());
                shoppingTrolleyEntity.setSalesVolume(shoppingTrolleyDto.getSalesVolume());
                shoppingTrolleyEntity.setTax(shoppingTrolleyDto.getTax());
                shoppingTrolleyEntity.setTaxAmount(shoppingTrolleyDto.getTaxAmount());
                shoppingTrolleyEntity.setStatus(0);
                shoppingTrolleyEntity.setCreatedTime(DateUtil.getCurrentDatetime());

                shoppingTrolleyEntities.add(shoppingTrolleyEntity);
            }
        }

        return null;
    }

    @Override
    public PaymentEntity getPaymentEntity(PaymentDto paymentDto) {

        PaymentEntity paymentEntity = new PaymentEntity();

        if (!FormatUtil.isEmpty(paymentDto)) {
            paymentEntity.setId(UUIDUtil.UString(24));
            paymentEntity.setUserId(paymentDto.getUserId());
            paymentEntity.setOrderId(paymentDto.getOrderId());
            paymentEntity.setPayType(paymentDto.getPayType());
            paymentEntity.setPayTraceCode(paymentDto.getPayCode());
            paymentEntity.setPayFor(paymentDto.getPayFor());
            paymentEntity.setStatus(0);
            paymentEntity.setCreateTime(DateUtil.getCurrentDatetime());

            return paymentEntity;
        }

        return null;
    }

    @Override
    public PayeeEntity getPayeeEntity(PayeeDto payeeDto) {

        PayeeEntity payeeEntity = new PayeeEntity();

        if (!FormatUtil.isEmpty(payeeDto)) {
            payeeEntity.setId(UUIDUtil.UString(24));
            payeeEntity.setPayeeName(payeeDto.getPayeeName());
            payeeEntity.setPayeeCidno(payeeDto.getCidno());
            payeeEntity.setPayeeCidUrl(payeeDto.getCid_url());
            payeeEntity.setUserId(payeeDto.getUserId());
            payeeEntity.setStatus(0);
            payeeEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return payeeEntity;
        }

        return null;
    }

    @Override
    public InvoiceDeliveryEntity getInvoiceDeliveryEntity(String orderKey, String addressKey, InvoiceDeliveryReqDto invoiceDeliveryReqDto) {

        InvoiceDeliveryEntity deliveryEntity = new InvoiceDeliveryEntity();

        if (!FormatUtil.isEmpty(invoiceDeliveryReqDto)) {
            deliveryEntity.setId(orderKey);
            deliveryEntity.setUserId(invoiceDeliveryReqDto.getUserId());
            deliveryEntity.setAddressId(addressKey);
            deliveryEntity.setExpressCompany(invoiceDeliveryReqDto.getExpressCompany());
            deliveryEntity.setStatus(0);
            deliveryEntity.setCreatedTime(DateUtil.getCurrentDatetime());

            return deliveryEntity;
        }

        return null;
    }
}
