package com.leshuibao.fragmentTax.controller.front;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/tradingHall")
@CrossOrigin
public class TradingHallShowController {

    //todo
    @Path("/showUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showUser(){
       return null;
    }

    //todo
    @Path("/showPayee")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showPayee(){
        return null;
    }

    //todo
    @Path("/showPayer")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showPayer(){
        return null;
    }

    //todo
    @Path("/showOrder")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrder(){
        return null;
    }
}
