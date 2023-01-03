package com.baeldung.springintegration.controllers;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

    public String submit() {
        if (message == null || message.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
                            ""));
            // Afficher un message d'erreur
            return null;
        }
        if (message.length() > 10) {
            // Afficher un message d'erreur
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
                            "Le message comporte trop de caractères"));
            RequestContext.getCurrentInstance().execute("document.getElementById('form:modalPanel').style.display='block';");
            return null;
        }

        // Traiter le message

        return "success";
    }
}
