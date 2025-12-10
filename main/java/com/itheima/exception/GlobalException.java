package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局的异常处理器
@RestControllerAdvice//声明注解
@Slf4j
public class GlobalException {

    //引用的的参数是所有的异常的形式，而不是一个
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("出错啦~",e);
        return Result.error("出错啦，请联系cyy同学~");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.info("出现了唯一冲突异常");
        String message=e.getMessage();//得到异常的信息字符串数组
        //对应出错的地方 是字符串数组中的第三个
        int i=message.indexOf("Duplicate entry");//定位到其所在的地方
        String err  =message.substring(i);//从该地方向后截取
        String []arr=err.split(" "); //分割字符串，使用正则表达式，以空格来分割，分割成字符串数组，重复的部分再第三个位置。
        return Result.error(arr[2]+"已存在");
    }


}
