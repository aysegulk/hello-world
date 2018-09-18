package kuntakyol.aysegul.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kuntakyol.aysegul.domain.Role;
import kuntakyol.aysegul.domain.User;

@Stateless
public class UserService {


	@PersistenceContext
	private EntityManager entityManager;

	public User findUser(String email, String password) 
	{
		List<User> users = entityManager
				.createQuery("select * from User m where m.email=:email and m.password=:pass", User.class)
				.setParameter("email", email).setParameter("pass", password).getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;

	}
	
	public User findUser(int userId) 
	{
		return entityManager.find(User.class,userId);
	}

	public void registerUser(User user) {
		entityManager.persist(user.getEmail());
		entityManager.persist(user.getPassword());
		entityManager.persist(user.getName());
		entityManager.persist(user.getSurname());
	}


	public void saveUser(User user) {
		Role userRole = entityManager.find(Role.class, 2);
		user.setRole(userRole);
		entityManager.persist(user);		
	}
	public void insertRolesIfNotExists() {
		List<Role> roles = entityManager.createQuery("select r from Role r",Role.class).getResultList();
		if(roles==null || roles.size()==0)
		{
			Role admin = new Role("admin",null);
			Role manager = new Role("manager", null);
			Role user = new Role("user", null);
			entityManager.persist(admin);
			entityManager.persist(manager);
			entityManager.persist(user);
		}
		
	}

		public User getUserWithRole(String email, String password) {
		//JPQL, JPAQL, EJBQL
	List<User> users = entityManager.createQuery("select u from User u where u.email=:email and u.password=:pass",User.class)
						.setParameter("email", email)
						.setParameter("pass",password)
						.getResultList();
			if(users.size()==1)
			{
				users.get(0).getRole().getRoleName();
				return users.get(0);
			}
		
		return null;
	}

}
