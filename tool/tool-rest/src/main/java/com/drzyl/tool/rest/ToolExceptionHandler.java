package com.drzyl.tool.rest;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.drzyl.tool.exception.ToolException;

/**
 * 请求异常拦截器</br>
 * 同一处理异常
 */
@Log4j
@RestControllerAdvice
public class ToolExceptionHandler {

  @ExceptionHandler(Exception.class)
  public Responses<?> exceptionHandler(HttpServletRequest request, Exception e) {
    Responses<?> responses = new Responses<>();
    if (log.isDebugEnabled()) e.printStackTrace();
    if (e instanceof ToolException) {
      responses.setException(((ToolException) e).getErrMsg());
      return responses;
    } else {
      responses.setException(ToolException.E_ERR);
      return responses;
    }
  }

  /**
   * 验证异常
   *
   * @param req
   * @param e
   * @return
   * @throws MethodArgumentNotValidException
   */
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  @ResponseBody
  public Responses<?> handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) throws MethodArgumentNotValidException {
    Responses<?> r = new Responses();
    BindingResult bindingResult = e.getBindingResult();
    String errorMesssage = "无效的请求:\n";

    for (FieldError fieldError : bindingResult.getFieldErrors()) {
      errorMesssage += fieldError.getDefaultMessage() + "\n";
    }
    r.isDefeated(errorMesssage);
    log.info("表单验证异常", e);
    return r;
  }

}
