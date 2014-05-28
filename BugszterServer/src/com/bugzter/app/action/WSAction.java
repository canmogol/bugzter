package com.bugzter.app.action;

import com.cdyne.wsf.Weather;
import com.cdyne.wsf.WeatherSoap;
import com.fererlab.action.BaseAction;
import com.fererlab.dto.Request;
import com.fererlab.dto.Response;
import com.fererlab.dto.Status;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * acm
 */
public class WSAction extends BaseAction {

    private Weather weather = new Weather();
    private WeatherSoap weatherSoap = weather.getWeatherSoap();

    public Response call(Request request) {
        if (request.getParams().containsKey("method") && request.getParams().get("method") != null) {
            String methodName = request.getParams().getValue("method").toString();
            Method foundMethod = null;
            for (Method method : weatherSoap.getClass().getMethods()) {
                if (method.getName().equals(methodName)) {
                    foundMethod = method;
                    break;
                }
            }
            Object[] args = null;
            if (request.getParams().containsKey("args") && request.getParams().get("args") != null) {
                args = request.getParams().getValue("args").toString().split(",");
            }
            if (foundMethod != null) {
                try {
                    Object wsResponse = foundMethod.invoke(weatherSoap, args);
                    return Response.create(request, toContent(request, wsResponse), Status.STATUS_OK);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return Response.create(request, "no method found", Status.STATUS_NOT_FOUND);
    }

}
