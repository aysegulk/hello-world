package kuntakyol.aysegul.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import kuntakyol.aysegul.business.UserService;
import kuntakyol.aysegul.domain.User;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String email;
	private String password;

	@EJB
	private UserService userService;

	private User loggedUser;

	public String login() {
		User user = userService.findUser(email, password);
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong credentials!!!"));
			return "unauthorized";
			
		} else {
			this.setLoggedUser(user);
			return "user/welcomepage?faces-redirect=true"; 
		}
	}

	public String logOut() {
		this.setLoggedUser(null);
		return "/login?faces-redirect=true";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	


}
