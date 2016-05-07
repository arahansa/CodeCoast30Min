package com.example.user.domain;

import com.example.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by arahansa on 2016-04-17.
 */
@Data
@Entity
@lombok.Builder
@AllArgsConstructor
public class User  extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", length = 100,nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20, nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "sign_in_provider", length = 20)
    private SocialMediaService signInProvider;

    public User() {}

    public static class UserBuilder{
        private User user;
        public UserBuilder() {
            user = new User();
            user.role = Role.ROLE_USER;
        }
    }

}
