package ab.tjl.tscommunity.advice;

import ab.tjl.tscommunity.dto.ResultDTO;
import ab.tjl.tscommunity.exception.CustomizeException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author:tangjilin
 * @Description:异常处理
 * @Date:Created in 15:28 2019/8/27
 * @Modified By:
 */
@ControllerAdvice
@Slf4j
public class CustomizeExceptionHandler {

        @ExceptionHandler(Exception.class)
        ModelAndView handle(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response) {
            if (e instanceof CustomizeException){
                model.addAttribute("message",e.getMessage());
            }else {
                model.addAttribute("message","服务器冒烟了，请稍后再试试。。。");
            }
            return new ModelAndView("error");
        }
}
