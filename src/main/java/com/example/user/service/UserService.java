package com.example.user.service;


import com.example.user.domain.User;
import com.example.user.dto.RegistrationForm;
import com.example.user.exception.DuplicateEmailException;

/**
 * @author Petri Kainulainen
 * @editor arahansa
 */
public interface UserService {

    /**
     * Creates a new user account to the service.
     * @param userAccountData   The information of the created user account.
     * @return  The information of the created user account.
     * @throws DuplicateEmailException Thrown when the email address is found from the database.
     */
    public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException;
}
