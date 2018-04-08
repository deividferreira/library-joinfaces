package br.eti.deividferreira.library.app.controller.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@SuppressWarnings("rawtypes")
@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {

    /**
     * Manda o objeto para o bean, convertido em LocalDate
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (value != null) {
	    return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	return null;
    }

    /**
     * Manda o objeto para a view, em String
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value != null) {
	    final LocalDate date = (LocalDate) value;
	    return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	return null;
    }
}
