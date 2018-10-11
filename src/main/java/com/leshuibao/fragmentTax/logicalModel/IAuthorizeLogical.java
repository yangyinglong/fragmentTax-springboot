package com.leshuibao.fragmentTax.logicalModel;

import com.leshuibao.fragmentTax.dao.entity.*;
import com.leshuibao.fragmentTax.dto.request.LoginReqDto;
import com.leshuibao.fragmentTax.dto.request.RegisterReqDto;

public interface IAuthorizeLogical {

    UserEntity getUserEntity(LoginReqDto loginReqDtoDto);

    UserEntity getUserEntity(RegisterReqDto registerReqDto);

    void addUser(UserEntity userEntity);

    SmsLogEntity getSmsLogEntity(String smsId);

    void addSmsLog(SmsLogEntity smsLogEntity);
}
