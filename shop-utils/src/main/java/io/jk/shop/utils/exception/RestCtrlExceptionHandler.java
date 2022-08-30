package io.jk.shop.utils.exception;

import io.jk.shop.utils.resp.Result;
import io.jk.shop.utils.constants.HttpCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description rest controller exception handler
 */
public class RestCtrlExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(RestCtrlExceptionHandler.class);

    /**
    * handle exception
    * @param e exception
    * @return exception message
    */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e){
        logger.error("server throw exception: ", e);
        return new Result<>(HttpCode.FAILURE, "execute failure", e.getMessage());
    }
}
