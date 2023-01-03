package com.baeldung.springintegration.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name = "textareaBean")
@SessionScoped
public class TextAreaBean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String submit(AjaxBehaviorEvent event) {
        if (message == null || message.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Message is required"));
            return null;
        }
        // Process the message
        return "success";
    }
}
