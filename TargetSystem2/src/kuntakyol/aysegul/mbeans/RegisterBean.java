package kuntakyol.aysegul.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import kuntakyol.aysegul.business.UserService;
import kuntakyol.aysegul.domain.User;

@ManagedBean
@RequestScoped
public class RegisterBean {

	private User user = new User();
	@EJB
	private UserService userService;

	public String register() {
		userService.registerUser(user);
		return "login";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	

}
