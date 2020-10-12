package com.buzzardsview.needalight.controller;

import com.buzzardsview.needalight.data.UserRepository;
import com.buzzardsview.needalight.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static com.buzzardsview.needalight.security.AppTokenProvider.getUserFromToken;

@RestController
@RequestMapping("rest/authenticate")
public class AuthenticateController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public boolean authenticateUser(HttpServletRequest request) {

        Optional<String> userFromToken;
        try {
            userFromToken = getUserFromToken(request);
            return userFromToken.isPresent();
        } catch (Throwable err) {
            return false;
        }
    }

    @GetMapping("admin")
    public boolean authenticateAdmin(HttpServletRequest request) {

        Optional<String> userFromToken;
        try {
            userFromToken = getUserFromToken(request);
            User user = userRepository.getByGoogleId(userFromToken.get()).orElseThrow();
            return user.isAdmin();
        } catch (Throwable err) {
            return false;
        }
    }

}
