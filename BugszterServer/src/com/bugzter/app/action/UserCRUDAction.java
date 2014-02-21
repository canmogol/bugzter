package com.bugzter.app.action;

import com.bugzter.app.model.User;
import com.fererlab.action.BaseJpaCRUDAction;
import com.fererlab.dto.*;

import java.util.Date;
import java.util.List;

public class UserCRUDAction extends BaseJpaCRUDAction<User> {

    public UserCRUDAction() {
        super(User.class);
    }

    public Response login(Request request) {
        if (request.getParams().containsKey("username") && request.getParams().containsKey("password")) {
            final String username = String.valueOf(request.getParams().getValue("username"));
            final String password = String.valueOf(request.getParams().getValue("password"));
            List<User> userList = findAll(
                    new ParamMap<String, Param<String, Object>>() {{
                        addParam(new Param<String, Object>("username", username));
                        addParam(new Param<String, Object>("password", password));
                    }}
            );

            if (userList.size() == 1) {
                //return Ok(request).toResponse();
                return Ok(request, "welcome user")
                        .add("user", userList.get(0))
                        .add("name", userList.get(0).getUsername())
                        .toResponse();
            } else if (userList.size() > 1) {
                return Ok(request, "there are multiple users for this username/password", Header.STATUS_FAIL).toResponse();

            } else {
                return Response.create(
                        request,
                        toContent(request,
                                new ServerResponse(
                                        new Header<String, Object>()
                                                .add(Header.MESSAGE, "for this 'username' and 'password' there is no user")
                                                .add(Header.STATUS, "failed"),
                                        new Content<String, Object>()
                                                .add("userList", userList)
                                )
                        ),
                        Status.STATUS_OK
                );
            }
        } else {
            return Response.create(request, toContent(request,
                    new ServerResponse("failed", "username' and 'password' cannot be empty")
                            .add("RequestDate", new Date())
            ), Status.STATUS_OK);
        }
    }

    public Response details(Request request) {
        User user;
        if (request.getParams().containsKey("id")) {
            user = find(Long.valueOf(String.valueOf(request.getParams().getValue("id"))));
            if (user == null) {
                return NotFound(request, "no user found for this id", Header.STATUS_FAIL).toResponse();
            } else {
                return Ok(request).add("user", user).toResponse();
            }
        } else {
            return NotFound(request, "param 'id' not found", Header.STATUS_FAIL).toResponse();
        }
    }

}
