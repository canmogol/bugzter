package com.bugzter.app.action;

import com.bugzter.app.model.User;
import com.fererlab.action.BaseJpaCRUDAction;
import com.fererlab.dto.Request;
import com.fererlab.dto.Response;
import com.fererlab.dto.Status;

public class UserCRUDAction extends BaseJpaCRUDAction<User> {

    public UserCRUDAction() {
        super(User.class);
    }

    public Response details(Request request) {
        User user;
        if (request.getParams().containsKey("id")) {
            user = find(Long.valueOf(String.valueOf(request.getParams().getValue("id"))));
            return Response.create(request, toContent(request, user), Status.STATUS_OK);
        } else {
            return Response.create(request, "param 'id' not found", Status.STATUS_NOT_FOUND);
        }
    }

}
