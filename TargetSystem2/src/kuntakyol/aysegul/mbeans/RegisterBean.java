package kuntakyol.aysegul.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import kuntakyol.aysegul.business.UserService;
import kuntakyol.aysegul.domain.User;


@SuppressWarnings({ "unused", "deprecation" })
@ManagedBean
@RequestScoped
public class RegisterBean {
	
	private User user = new User();
	@EJB
	private UserService userService;
	
	public String register()
	{
		userService.saveUser(this.user);
		return "login";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	

}
