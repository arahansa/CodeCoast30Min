package com.example.dto;

import com.example.domain.user.Role;
import com.example.domain.user.SocialMediaService;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;

import java.util.Collection;
import java.util.Set;

/**
 * Created by arahansa on 2016-04-17.
 */
@Data
@lombok.Builder
public class ExampleUserDetails  extends SocialUser {

    private Long id;

    private String firstName;

    private String lastName;

    private Role role;

    private SocialMediaService socialSignInProvider;

    public ExampleUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public static class ExampleUserDetailsBuilder{
        private String password;
        private String username;
        private Set<GrantedAuthority> authorities;
        public ExampleUserDetailsBuilder password(String password){
            if (password == null) {
                password = "SocialUser";
            }
            this.password = password;
            return this;
        }
        public ExampleUserDetailsBuilder username(String username) {
            this.username = username;
            return this;
        }

        public ExampleUserDetails build() {
            ExampleUserDetails user = new ExampleUserDetails(username, password, authorities);
            user.id = id;
            user.firstName = firstName;
            user.lastName = lastName;
            user.role = role;
            user.socialSignInProvider = socialSignInProvider;
            return user;
        }
    }


}
