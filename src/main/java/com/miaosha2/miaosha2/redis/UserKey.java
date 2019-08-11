package com.miaosha2.miaosha2.redis;

/**
 * @author xyq
 * @date 2019/08/02
 */
public class UserKey extends BasePrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByNme = new UserKey("name");
}
