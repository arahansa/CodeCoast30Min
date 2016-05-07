package com.example.security.util;

import com.example.security.dto.ExampleUserDetails;
import com.example.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by jarvis on 2016. 5. 6..
 */
public class SecurityUtil {
    private static final Logger log = LoggerFactory.getLogger(SecurityUtil.class);

    public static void logInUser(User user) {
        log.info("Logging in user: {}", user);

        ExampleUserDetails userDetails = ExampleUserDetails.builder()
                .firstName(user.getFirstName())
                .id(user.getId())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .role(user.getRole())
                .socialSignInProvider(user.getSignInProvider())
                .username(user.getEmail())
                .build();
        log.debug("Logging in principal: {}", userDetails);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        log.info("User: {} has been logged in.", userDetails);
    }
}
