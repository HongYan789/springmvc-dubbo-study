package com.lppz.ehr.dubbox.provider;


import com.lppz.ehr.bean.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("users")
public interface IUserService {
    @GET
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    public String registerUser(@QueryParam("name") String name);

     //注册
     @POST
     @Path("regist")
     @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
     @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
     public String regist(User user);

     //查询
     @POST
     @Path("{id:\\d+}")
     @Produces({ MediaType.APPLICATION_JSON })
     public User queryById(@PathParam("id") Long id);

}

