package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class CalcBB {
	private String amount;
	private String percent;
	private String howMany;

	private Float result;

	@Inject
	FacesContext ctx;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent; 
	}

	public String getHowMany() {
		return howMany;
	}

	public void setHowMany(String howMany) {
		this.howMany = howMany; 
	}

	public Float getResult() {
		return result;
	}

	public void setResult(Float result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			float amountVal = Float.parseFloat(this.amount);
			float percentVal = Float.parseFloat(this.percent);
			float howManyVal = Float.parseFloat(this.howMany);

			result = (amountVal * (percentVal / 100)) / howManyVal;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}


	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + result, null));
		}
		return null;
	}

	public String info() {
		return "info";
	}
}
