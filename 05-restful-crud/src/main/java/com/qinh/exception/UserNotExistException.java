package com.qinh.exception;

/**
 * 自定义异常
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-11-11:02
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException(String message) {
        super(message);
    }


    public UserNotExistException() {
        super("用户不存在");
    }
}
