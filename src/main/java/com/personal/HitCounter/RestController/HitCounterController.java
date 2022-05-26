package com.personal.HitCounter.RestController;

import java.nio.charset.Charset;
import java.util.Arrays;

import com.personal.HitCounter.Entity.ProfileCounterMap;

import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class HitCounterController{
    public ProfileCounterMap holder ;
    public HitCounterController(){
        System.out.println("Constructor Initialized");
        holder = new ProfileCounterMap();
    }
    @RequestMapping(value = "/profileViewCounter", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object getProfileViewCounter(@RequestParam(value = "userName",defaultValue = "") String userName){
        System.out.println("request receieved with username as :"+userName);
        // length check
        if(userName.length()<3)
            return "UserName should be alteast 3 character long!!!";
        // Only numbers checks
        if(!userName.matches("[A-z]+[0-9]*[A-z0-9]*"))
            return "UserName should be alphanumeric!!!";
        System.out.println("userName check Pass for username : "+userName);
        
        return String.valueOf(holder.getCount(userName)).getBytes();
    }
}