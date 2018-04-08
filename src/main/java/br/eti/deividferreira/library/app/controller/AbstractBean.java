package br.eti.deividferreira.library.app.controller;

import java.io.Serializable;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import lombok.Getter;

public class AbstractBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    protected ViewState viewState;
    private RequestContext requestContext = RequestContext.getCurrentInstance();

    /**
     * 
     */
    private void updateDefaultMessages() {
	if (this.getDefaultMessagesComponentId() != null && !this.getDefaultMessagesComponentId().isEmpty()) {
	    this.temporizeHiding(this.getDefaultMessagesComponentId());
	}
    }

    protected String getDefaultMessagesComponentId() {
	return "messages";
    }

    /**
     * 
     * @param componentId
     */
    protected void temporizeHiding(String componentId) {
	this.updateComponent(componentId);
	this.executeScript("setTimeout(\"$(\'#" + componentId + "\').slideUp(300)\", 8000)");
    }

    /**
     * 
     * @param componentId
     */
    protected void updateComponent(String componentId) {
	this.requestContext.update(componentId);
    }

    /**
     * 
     * @param script
     */
    protected void executeScript(String script) {
	this.requestContext.execute(script);
    }

    /**
     * 
     * @param updateDefault
     * @param message
     * @param parameters
     */
    protected void addInfo(boolean updateDefault, String message, Object... parameters) {
	Messages.addInfo(null, message, parameters);
	if (updateDefault)
	    this.updateDefaultMessages();
    }

    /**
     * 
     * @param updateDefault
     * @param message
     * @param parameters
     */
    protected void addError(boolean updateDefault, String message, Object... parameters) {
	Messages.addError(null, message, parameters);
	if (updateDefault)
	    this.updateDefaultMessages();
    }

    /**
     * 
     * @param updateDefault
     * @param message
     * @param parameters
     */
    protected void addWarning(boolean updateDefault, String message, Object... parameters) {
	Messages.addWarn(null, message, parameters);
	if (updateDefault)
	    this.updateDefaultMessages();
    }

    /**
     * 
     */
    protected enum ViewState {
	ADDING, LISTING, INSERTING, EDITING, DELETING, DETAILING;
    }
}
