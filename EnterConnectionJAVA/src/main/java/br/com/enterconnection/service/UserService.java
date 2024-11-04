package br.com.enterconnection.service;

public interface UserService {
    boolean validateUser(String username, String password);
    boolean registerUser(String username, String password);
}
