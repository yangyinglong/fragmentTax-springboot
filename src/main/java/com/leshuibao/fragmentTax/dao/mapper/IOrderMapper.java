package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.OrderEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface IOrderMapper {
@Select("SELECT `id`, `trade_name`, `tax_rate`, `payer_id`, `payee_id`, `address_id`, `express_company`, `express_fee`, `express_tracking_code`, `total_tax_amout`, `audit_status`, `auditer`, `status`, `created_time`, `changed_lasttime` FROM `order`")
@Results({
@Result(property = "id", column = "id"), 
@Result(property = "tradeName", column = "trade_name"), 
@Result(property = "taxRate", column = "tax_rate"), 
@Result(property = "payerId", column = "payer_id"), 
@Result(property = "payeeId", column = "payee_id"), 
@Result(property = "addressId", column = "address_id"), 
@Result(property = "expressCompany", column = "express_company"), 
@Result(property = "expressFee", column = "express_fee"), 
@Result(property = "expressTrackingCode", column = "express_tracking_code"), 
@Result(property = "totalTaxAmout", column = "total_tax_amout"), 
@Result(property = "auditStatus", column = "audit_status"), 
@Result(property = "auditer", column = "auditer"), 
@Result(property = "status", column = "status"), 
@Result(property = "createdTime", column = "created_time"), 
@Result(property = "changedLasttime", column = "changed_lasttime")
})
List<OrderEntity> queryAll();
@Select("SELECT `id`, `trade_name`, `tax_rate`, `payer_id`, `payee_id`, `address_id`, `express_company`, `express_fee`, `express_tracking_code`, `total_tax_amout`, `audit_status`, `auditer`, `status`, `created_time`, `changed_lasttime` FROM `order` WHERE `id` = #{id}")
@Results({
@Result(property = "id", column = "id"), 
@Result(property = "tradeName", column = "trade_name"), 
@Result(property = "taxRate", column = "tax_rate"), 
@Result(property = "payerId", column = "payer_id"), 
@Result(property = "payeeId", column = "payee_id"), 
@Result(property = "addressId", column = "address_id"), 
@Result(property = "expressCompany", column = "express_company"), 
@Result(property = "expressFee", column = "express_fee"), 
@Result(property = "expressTrackingCode", column = "express_tracking_code"), 
@Result(property = "totalTaxAmout", column = "total_tax_amout"), 
@Result(property = "auditStatus", column = "audit_status"), 
@Result(property = "auditer", column = "auditer"), 
@Result(property = "status", column = "status"), 
@Result(property = "createdTime", column = "created_time"), 
@Result(property = "changedLasttime", column = "changed_lasttime")
})
OrderEntity queryByKey(@Param("id") String id);

@Insert("INSERT INTO `order`(`id`, `trade_name`, `tax_rate`, `payer_id`, `payee_id`, `address_id`, `express_company`, `express_fee`, `express_tracking_code`, `total_tax_amout`, `audit_status`, `auditer`, `status`, `created_time`) VALUES(#{id}, #{tradeName}, #{taxRate}, #{payerId}, #{payeeId}, #{addressId}, #{expressCompany}, #{expressFee}, #{expressTrackingCode}, #{totalTaxAmout}, #{auditStatus}, #{auditer}, #{status}, #{createdTime})")
void insert(OrderEntity orderEntity);

@Update("UPDATE `order` SET id=#{id}, trade_name=#{tradeName}, tax_rate=#{taxRate}, payer_id=#{payerId}, payee_id=#{payeeId}, address_id=#{addressId}, express_company=#{expressCompany}, express_fee=#{expressFee}, express_tracking_code=#{expressTrackingCode}, total_tax_amout=#{totalTaxAmout}, audit_status=#{auditStatus}, auditer=#{auditer}, status=#{status}, created_time=#{createdTime} WHERE `id` = #{id}")
void update(OrderEntity orderEntity);

@Delete("DELETE FROM `order` WHERE `id` = #{id}")
void delete(@Param("id") String id);

}