package com.example.backendspring3.common;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

public abstract class ControllerCommon {

    @Autowired
    private  MessageSource messageSource;

    private static final String OK = "SUCCESS";
    private static final String ERROR = "NO_FOUND";

    public String getMessageByCode(String code) {
        String message = messageSource.getMessage(code,new String[]{"not di","khong di"}, Locale.ENGLISH);

        return message;
    }

    public ResponseEntity<?> ok(String code, Object data) {
        Object common = new Object();
        BeanUtils.copyProperties(common,data);
        Response response = new Response(code,getMessageByCode(code),data,OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public ResponseEntity<?> ero(String code,Object data){
        Object common = new Object();
        BeanUtils.copyProperties(common, data);
        Response response = new Response(code,getMessageByCode(code),data,ERROR);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    public ResponseEntity<?> eroHande(Exception code){
        Response response = new Response();
        response.setCode(code.getMessage());
        response.setData(null);
        response.setMessage(getMessageByCode(code.getMessage()));
        response.setMessage(ERROR);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
