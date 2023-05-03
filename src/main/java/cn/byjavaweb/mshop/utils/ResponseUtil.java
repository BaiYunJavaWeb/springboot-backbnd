package cn.byjavaweb.mshop.utils;

import cn.byjavaweb.mshop.entity.Message;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    private static final Gson gson;

    static {
        gson = new Gson();
    }
    
    /**
     *  see ResponseUtil.makeResponse()
     */
    public ResponseEntity<String> response(Object msg, HttpStatus httpStatus) {
        return makeResponse(msg, httpStatus);
    }
    
    public static ResponseEntity<String> makeResponse(Object msg, HttpStatus httpStatus) {
        Message message = new Message();
        message.setMsg(msg);
        return new ResponseEntity<>(gson.toJson(message), httpStatus);
    }
}
