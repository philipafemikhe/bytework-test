package com.servbyte.app.controllers;

import com.servbyte.app.entities.FoodProvider;
import com.servbyte.app.jwtsecurity.JwtGenerator;
import com.servbyte.app.models.LoginDetails;
import com.servbyte.app.entities.User;
import com.servbyte.app.models.jwt.JwtUser;
import com.servbyte.app.services.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("signup")
    public User createAccount(@RequestBody User user){
        User newUser = this.userService.createAccount(user);
        return newUser;
    }

    @PostMapping(path = "/login")
    public String login(LoginDetails loginDetails){
        String encodedPsw = bCryptPasswordEncoder.encode("password");
        User thisUser = userService.findByUsernameAndPassword(loginDetails.getUsername(), encodedPsw);

        JSONObject resposeObj = new JSONObject();
        try {
            System.out.println(resposeObj.get("data").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(thisUser != null){
            try {
                resposeObj.put("status", "Success!");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jwtGenerator.generate(new JwtUser(loginDetails.getUsername(),-1, ""));
        }else{
            try {
                resposeObj.put("status", "Failed!");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return "Error";
        }
    }

}
