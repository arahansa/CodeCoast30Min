package com.example.service.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * Created by arahansa on 2016-04-17.
 */
@Slf4j
public class SimpleSocialUserDetailService  implements SocialUserDetailsService  {

    private UserDetailsService userDetailsService;

    public SimpleSocialUserDetailService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.debug("Loading user by user id: {}", userId);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
        log.debug("Found user details: {}", userDetails);
        return (SocialUserDetails) userDetails;
    }
}
