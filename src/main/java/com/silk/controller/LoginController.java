
package com.silk.controller;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silk.dao.UserDaoI;
import com.silk.entity.User;
import com.silk.msg.CommonResponse;
import com.silk.msg.UserReq;


@RestController()
@RequestMapping(value="/user")
public class LoginController
{
    @Resource
    UserDaoI userDao;
    
    /** 获取验证码
     * 
     * @param phone
     * @return */
    @RequestMapping(method=RequestMethod.GET)
    public CommonResponse getLoginCode(@RequestParam(value = "phone") String phone)
    {
        System.out.println(phone);
        // TODO
        User u = userDao.findOne(Long.parseLong(phone));
        if (null == u)
        {
            u = new User(Long.parseLong(phone), 1234);
            
        }
        u.setCode(1234);
        userDao.save(u);
        
        return CommonResponse.genSuccess(null);
    }
    
    /** 登录
     * 
     * @param user
     * @return */
    @RequestMapping(method=RequestMethod.POST)
    public CommonResponse login(@RequestBody UserReq user)
    {
        System.out.println(user);
        // TODO
        User u = userDao.findOne(Long.parseLong(user.getPhone()));
        if(u == null)
        {
        	return CommonResponse.genFail("用户没有录入系统");
        }
        if (u.getCode() == user.getCode() && System.currentTimeMillis() - u.getLastModifyTimestamp() <= 60000)
        {
            if(StringUtils.isEmpty(u.getName()))
            {
                return CommonResponse.genSuccess("new user");
            }
            return CommonResponse.genSuccess("not new user");
        }
        return CommonResponse.genFail(null);
    }
    
    @RequestMapping(method=RequestMethod.PUT)
    public CommonResponse additional(@RequestBody UserReq user)
    {
        User u = userDao.findOne(Long.parseLong(user.getPhone()));
        u.setName(user.getName());
        userDao.save(u);
        return CommonResponse.genSuccess(null);
    }
}
