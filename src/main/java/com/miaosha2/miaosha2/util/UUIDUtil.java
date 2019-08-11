package com.miaosha2.miaosha2.util;

import java.util.UUID;

/**
 * @author xyq
 * @date 2019/08/03
 */
public class UUIDUtil {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
