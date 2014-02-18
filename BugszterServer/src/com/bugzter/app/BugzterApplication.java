package com.bugzter.app;

import com.fererlab.app.BaseApplication;
import com.fererlab.db.EM;
import com.fererlab.dto.Request;
import com.fererlab.dto.RequestKeys;
import com.fererlab.dto.Response;

/**
 * acm | 1/10/13
 */
public class BugzterApplication extends BaseApplication {

    @Override
    public void start() {
        if (!isDevelopmentModeOn()) {
            try {
                EM.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Response runApplication(final Request request) {
        // read the cookie to Session object
        request.getSession().fromCookie(this.getClass().getPackage().getName() + "." + this.getClass().getName(),
                "23746s2s8ad723423jh23746s2s8ad723423jh23-989asc2213sad12311234t543687");
        if (isDevelopmentModeOn() && !request.getParams().get(RequestKeys.URI.getValue()).getValue().toString().startsWith("/_/")) {
            try {
                EM.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // run application
        return super.runApplication(request);
    }

    @Override
    public void stop() {
        EM.stop();
    }

}