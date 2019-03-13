package com.ifpb.control.services;

import com.ifpb.control.services.exceptions.EncodeExcpetion;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encode {

    public static String md2(String senha) throws EncodeExcpetion {
        return DigestUtils.sha256Hex(senha);
    }

}
