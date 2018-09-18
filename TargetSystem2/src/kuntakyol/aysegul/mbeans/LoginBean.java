package kuntakyol.aysegul.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import kuntakyol.aysegul.business.UserService;
import kuntakyol.aysegul.domain.Role;
import kuntakyol.aysegul.domain.User;




@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String email;
	private String password;
	
	private Role role;
	@EJB
	private UserService userService;
	
	private User loggedInUser;
	

	public String login()
	{		
		System.out.println("hatatata");
		User user = userService.getUserWithRole(email,password);
		//LoginBean deki rol set edilecek (Login olan user ın rolü)
		this.role=user.getRole();
		this.loggedInUser = user;
		//daha sonra 
		//User hangi role sahipse o klasöre yönlendir
		if(this.role.getRoleName().equals("admin"))
		{
			return "admin/defineuser?faces-redirect=true";
		} 
		else if(this.role.getRoleName().equals("manager"))
		{
			return "user/manager/welcome?faces-redirect=true";	
		}
		else if(this.role.getRoleName().equals("user"))
		{
			return "user/registration?faces-redirect=true";	
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Role does not exists!!!"));
		return "unauthorized";
			
	}
	
	public String logOut() {
		this.setLoggedInUser(null);
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public User getLoggedInUser() {
		return loggedInUser;
	}


	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}


	

}
