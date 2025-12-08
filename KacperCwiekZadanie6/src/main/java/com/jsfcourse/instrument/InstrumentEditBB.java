package com.jsfcourse.instrument;

import java.io.IOException;
import java.io.Serializable;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import com.jsfcourse.dao.InstrumentDAO;
import com.jsfcourse.entities.Instruments;

@Named
@ViewScoped
public class InstrumentEditBB implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String PAGE_INSTRUMENT_LIST = "instrumentList?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;
    private Instruments instrument = new Instruments();
    private Instruments loaded = null;

    @EJB
    InstrumentDAO instrumentDAO;
    @Inject
    FacesContext context;
    @Inject
    Flash flash;

    public Instruments getInstrument() {
        return instrument;
    }
    public void onLoad() throws IOException {
        
        loaded = (Instruments) flash.get("instrument");    
        if (loaded != null) {
            instrument = loaded;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
        }
    }

    public String saveData() {
        if (loaded == null) {
            return PAGE_STAY_AT_THE_SAME;
        }
        try {
            if (instrument.getId() == null) {
                instrumentDAO.create(instrument);
            } else {
                instrumentDAO.merge(instrument);
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "wystąpił błąd podczas zapisu", null));
            return PAGE_STAY_AT_THE_SAME;
        }
        return PAGE_INSTRUMENT_LIST;
    }
}