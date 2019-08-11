package com.miaosha2.miaosha2.exception;

import com.miaosha2.miaosha2.result.CodeMsg;

/**
 * @author xyq
 * @date 2019/08/03
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 2595322705749867768L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm){
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
