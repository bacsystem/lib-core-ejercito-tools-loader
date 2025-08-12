package pe.mil.ejercito.lib.utils.componets.interceptors;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pe.mil.ejercito.lib.utils.componets.helpers.ContextCurrentTimeHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static pe.mil.ejercito.lib.utils.constants.BaseLoggerConstant.HTTP_REQUEST_MESSAGE;
import static pe.mil.ejercito.lib.utils.constants.BaseLoggerConstant.HTTP_REQUEST_TIME;

/**
 * MetricsLoggerInterceptor
 * <p>
 * MetricsLoggerInterceptor class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 26/02/2024
 */
@Log4j2
public class MetricsLoggerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long start = ContextCurrentTimeHelper.getStarTime();
        log.info(HTTP_REQUEST_TIME, HTTP_REQUEST_MESSAGE, ContextCurrentTimeHelper.getTimestamp(start));
        request.setAttribute(HTTP_REQUEST_MESSAGE, start);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long start = (Long) request.getAttribute(HTTP_REQUEST_MESSAGE);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        log.debug("Execute Time: {} milliseconds", ContextCurrentTimeHelper.getTotalTime(start));
    }
}