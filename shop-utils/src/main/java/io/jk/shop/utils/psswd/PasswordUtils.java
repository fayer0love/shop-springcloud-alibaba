package io.jk.shop.utils.psswd;

import io.jk.shop.utils.md5.MD5Hash;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description password utils
 */
public class PasswordUtils {

        public static String getPassword(String password){
            if (password == null || password.trim().isEmpty()) return password;
            for (int i = 0; i < 5; i++){
                password = MD5Hash.md5Java(password);
            }
            return password;
        }
}
