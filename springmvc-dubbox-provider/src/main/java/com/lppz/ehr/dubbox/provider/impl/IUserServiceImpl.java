package com.lppz.ehr.dubbox.provider.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSONObject;
import com.lppz.ehr.bean.User;
import com.lppz.ehr.dubbox.provider.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import java.util.Date;


//@Path("users")
public class IUserServiceImpl  implements IUserService{

//    @GET
//    @Path("register")
//    @Produces("application/json; charset=UTF-8")
    public String registerUser(@QueryParam("name") String name) {
        return "Hello " + name;
    }

//    @POST
//    @Path("regist")
//    @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
    @Override
    public String regist(User user) {
        System.out.println(user);
        HttpServletRequest request = (HttpServletRequest) RpcContext.getContext().getRequest();
        String host = request.getLocalAddr();
        JSONObject json = new JSONObject();
        json.put("name",user.getName());
        json.put("ip",host);
        return json.toJSONString();
    }

//    @POST
//    @Path("{id:\\d+}")
//    @Produces({ MediaType.APPLICATION_JSON })
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("jetty");
        user.setCreateTime(new Date());
        return user;
    }

}
