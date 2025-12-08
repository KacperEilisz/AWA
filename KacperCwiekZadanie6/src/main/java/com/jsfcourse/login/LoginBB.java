package com.jsfcourse.login;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.simplesecurity.RemoteClient;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.jsfcourse.dao.UserDAO;
import com.jsfcourse.entities.Users;

@Named
@RequestScoped
public class LoginBB {
    private static final String PAGE_MAIN = "/instrumentList?faces-redirect=true";
    private static final String PAGE_LOGIN = "/login?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;

    private String login;
    private String pass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Inject
    UserDAO userDAO;

    public String doLogin() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        Users user = userDAO.getUserFromDatabase(login, pass);

        if (user == null) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Niepoprawny login lub hasło", null));
            return PAGE_STAY_AT_THE_SAME;
        }

        RemoteClient<Users> client = new RemoteClient<Users>();
        client.setDetails(user);
        
        List<String> roles = userDAO.getUserRolesFromDatabase(user);
        
        if (roles != null) {
            for (String role: roles) {
                client.getRoles().add(role);
            }
        }
    
        HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
        client.store(request);

        return PAGE_MAIN;
    }
    
    public String doLogout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        session.invalidate();
        return PAGE_LOGIN;
    }
}