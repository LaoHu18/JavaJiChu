package com.vince.NJAVASE_Exemple.utils;

/**
 * 用于处理登陆时出现的自定义异常
 */
public class BusinessException extends RuntimeException{
    public BusinessException(){
        super();
    }
    public BusinessException(String errorMessage){
        super(errorMessage);
    }
}
