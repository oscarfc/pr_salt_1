/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.salt.pr_salt_1.security;

/**
 *
 * @author oscar.favero
 */
public class JwtTokenException extends RuntimeException {

    public JwtTokenException(String message) {
        super(message);
    }
    
    
}
