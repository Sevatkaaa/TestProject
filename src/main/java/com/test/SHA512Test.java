package com.test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512Test {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String orderId = "1075874";
        String statusCode = "200";
        String grossAmount = "15000.00";
        String serverKey = "Mid-server-857TuT-ukPBAmsaLsYFMUX6i";

        String code = orderId + statusCode + grossAmount + serverKey;
        String signatureKey = "f688fd68580c979cfd9fe66db7f379f815b440e0300fa3cb806218522c6afebedec75b40cef001f2267a2fd8f418a4ad097997e7d1599c3df426468a7680d7c6";
        String sha256hex = sha512(code);
        System.out.println(sha256hex);
        System.out.println(signatureKey);
    }
    public static String sha512(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("SHA-512");
        byte[] digest = md5.digest(input.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; ++i) {
            sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

}
