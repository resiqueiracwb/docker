/**
 *
 */
package com.painel.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordEncolder {

    public static String encodePass(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return passwordEncoder.encode(password);
    }

    public static void main(String[] args) {
        System.out.println(encodePass("!78G2klsVivo"));
    }
}
