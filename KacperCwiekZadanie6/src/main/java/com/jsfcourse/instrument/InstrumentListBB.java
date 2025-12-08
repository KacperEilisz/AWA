package com.jsfcourse.instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.servlet.http.HttpSession;
import com.jsfcourse.dao.InstrumentDAO;
import com.jsfcourse.entities.Instruments;

@Named
@RequestScoped
public class InstrumentListBB {
	private static final String PAGE_INSTRUMENT_EDIT = "instrumentEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private String name;	
	@Inject
	ExternalContext extcontext;
	@Inject
	Flash flash;
	@EJB
	InstrumentDAO instrumentDAO;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Instruments> getFullList(){
		return instrumentDAO.getFullList();
	}
	public List<Instruments> getList(){
		List<Instruments> list = null;
		Map<String,Object> searchParams = new HashMap<String, Object>();
		if (name != null && name.length() > 0){
			searchParams.put("name", name);
		}
		list = instrumentDAO.getList(searchParams);	
		return list;
	}
	public String newInstrument(){
		Instruments instrument = new Instruments();	
		flash.put("instrument", instrument);
		return PAGE_INSTRUMENT_EDIT;
	}
	public String editInstrument(Instruments instrument){
		flash.put("instrument", instrument);
		return PAGE_INSTRUMENT_EDIT;
	}
	public String deleteInstrument(Instruments instrument){
		instrumentDAO.remove(instrument);
		return PAGE_STAY_AT_THE_SAME;
	}
}