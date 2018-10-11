package com.leshuibao.fragmentTax.logicalModel;

import com.leshuibao.fragmentTax.dao.entity.SmsLogEntity;
import com.leshuibao.fragmentTax.dao.entity.UserEntity;
import com.leshuibao.fragmentTax.dao.mapper.ISmsLogMapper;
import com.leshuibao.fragmentTax.dao.mapper.IUserMapper;
import com.leshuibao.fragmentTax.dto.request.LoginReqDto;
import com.leshuibao.fragmentTax.dto.request.RegisterReqDto;
import com.leshuibao.fragmentTax.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeLogical implements IAuthorizeLogical {

    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private ISmsLogMapper smsInfoMapper;
//    @Autowired
//    public AuthorizeLogical(IUserMapper userMapper){
//        this.userMapper = userMapper;
//    }

    @Override
    public UserEntity getUserEntity(LoginReqDto loginReqDto) {

        UserEntity userEntity;

        try {
            userEntity = userMapper.queryByUsername(loginReqDto.getUsername());
            if (FormatUtil.isEmpty(userEntity)) {
                userEntity = userMapper.queryByPhone(loginReqDto.getUsername());
            }
        } catch (Exception e) {
            return null;
        }

        if (!FormatUtil.isEmpty(userEntity) && loginReqDto.getPassword().equals(userEntity.getPassword())) {
            return userEntity;
        }

        return null;
    }

    @Override
    public UserEntity getUserEntity(RegisterReqDto registerReqDto) {

        try {
            return userMapper.queryByPhone(registerReqDto.getPhone());
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void addUser(UserEntity userEntity) {
        userMapper.insert(userEntity);
    }


    @Override
    public SmsLogEntity getSmsLogEntity(String smsId) {
        return smsInfoMapper.queryByKey(smsId);
    }

    @Override
    public void addSmsLog(SmsLogEntity smsLogEntity) {
        smsInfoMapper.insert(smsLogEntity);
    }

}
