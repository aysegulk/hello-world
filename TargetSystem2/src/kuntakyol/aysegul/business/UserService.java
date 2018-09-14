package kuntakyol.aysegul.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kuntakyol.aysegul.domain.User;

@Stateless
public class UserService {


	@PersistenceContext
	private EntityManager entityManager;

	public User findUser(String email, String password) 
	{
		List<User> users = entityManager
				.createQuery("select m from User m where m.email=:email and m.password=:pass", User.class)
				.setParameter("email", email).setParameter("pass", password).getResultList();
		if (users.size() == 1) {
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
}
