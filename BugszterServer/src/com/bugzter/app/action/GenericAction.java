package com.bugzter.app.action;

import com.fererlab.action.BaseAction;
import com.fererlab.action.SupportCRUDAction;
import com.fererlab.dto.*;

/**
 * acm | 1/22/13
 */
@SuppressWarnings("unchecked")
public class GenericAction extends BaseAction {
    private String entityPackage = "model";

    public GenericAction() {
        //com.bugzter.app.action.GenericAction
        System.out.println("---> pn: " + this.getClass().getPackage().getName());
        System.out.println("---> li: " + this.getClass().getPackage().getName().lastIndexOf(".action."));
        String p1 = this.getClass().getPackage().getName().substring(0, this.getClass().getPackage().getName().lastIndexOf(".action."));
        System.out.println("---> p1:" + p1);
        entityPackage = p1 + ".model";
        System.out.println("---> entityPackage: " + entityPackage);

    }

    public Response find(Request request) {
        Class<? extends Model> modelClass = getModelClass(request);
        if (modelClass != null) {
            return new SupportCRUDAction(modelClass).find(request);
        }
        return Response.create(request, Status.STATUS_NOT_FOUND.getMessage(), Status.STATUS_NOT_FOUND);
    }

    public Response findAll(Request request) {
        Class<? extends Model> modelClass = getModelClass(request);
        if (modelClass != null) {
            return new SupportCRUDAction(modelClass).findAll(request);
        }
        return Response.create(request, Status.STATUS_NOT_FOUND.getMessage(), Status.STATUS_NOT_FOUND);
    }

    public Response create(Request request) {
        Class<? extends Model> modelClass = getModelClass(request);
        if (modelClass != null) {
            return new SupportCRUDAction(modelClass).create(request);
        }
        return Response.create(request, Status.STATUS_NOT_FOUND.getMessage(), Status.STATUS_NOT_FOUND);
    }

    public Response update(Request request) {
        Class<? extends Model> modelClass = getModelClass(request);
        if (modelClass != null) {
            return new SupportCRUDAction(modelClass).update(request);
        }
        return Response.create(request, Status.STATUS_NOT_FOUND.getMessage(), Status.STATUS_NOT_FOUND);
    }

    public Response delete(Request request) {
        Class<? extends Model> modelClass = getModelClass(request);
        if (modelClass != null) {
            return new SupportCRUDAction(modelClass).delete(request);
        }
        return Response.create(request, Status.STATUS_NOT_FOUND.getMessage(), Status.STATUS_NOT_FOUND);
    }

    public Response deleteAll(Request request) {
        Class<? extends Model> modelClass = getModelClass(request);
        if (modelClass != null) {
            return new SupportCRUDAction(modelClass).deleteAll(request);
        }
        return Response.create(request, Status.STATUS_NOT_FOUND.getMessage(), Status.STATUS_NOT_FOUND);
    }

    private Class<? extends Model> getModelClass(Request request) {
        String[] requestURIParts = request.getParams().get(RequestKeys.URI.getValue()).getValue().toString().split("/");
        if (requestURIParts.length > 2) {
            String modelClassName = requestURIParts[3].trim();
            if (!modelClassName.isEmpty()) {
                modelClassName = modelClassName.substring(0, 1).toUpperCase() + modelClassName.substring(1);
                try {
                    return (Class<? extends Model>) Class.forName(entityPackage + "." + modelClassName);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
