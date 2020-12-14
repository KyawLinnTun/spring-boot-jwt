package com.example.springbootjwt.security;

public class SecurityConstant {

    public static  final String SECRET="SecretKeyToGenJWTs";
    public static  final long EXPIRATION_TIME=864_000_000;//10 DAYS
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String HEADER_STRING="Authorization";
    public static final String SIGN_UP_URL="/users/sing-up";

}
