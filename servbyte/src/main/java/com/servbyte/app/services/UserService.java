package com.servbyte.app.services;

import com.servbyte.app.entities.FoodProvider;
import com.servbyte.app.entities.User;
import com.servbyte.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodVendorService foodVendorService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUsernameAndPassword(String username, String encodedPsw) {
//        return userRepository.findByEmailAndPassword(username, encodedPsw);
        return userRepository.findByUsername(username);
    }

    public User createAccount(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User thisUser = this.userRepository.save(user);
        if(thisUser.getCcountType() == "Service Provider"){
            FoodProvider provider = new FoodProvider();
            provider.setCity(thisUser.getCity());
            provider.setEmail(thisUser.getUsername());
            provider.setLogo("-");
            provider.setPhone(thisUser.getPhone());
            provider.setProvider_name(thisUser.getUsername());
            this.foodVendorService.createVendor(provider);
        }
        return thisUser;
    }
}
