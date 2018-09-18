package kuntakyol.aysegul.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kuntakyol.aysegul.domain.Criteria;

@Stateless
public class CriteriaService {

	@PersistenceContext 
	private	EntityManager entityMan;
		
	public void createCrit(Criteria criteria) {
		entityMan.persist(criteria.getCriteriaName());
		entityMan.persist(criteria.getStartDate());
		entityMan.persist(criteria.getFinishDate());
		entityMan.persist(criteria.getUnit());
		entityMan.persist(criteria.getTotalAmount());
		
	}
	public Criteria findCrit(int id, String criteriaName) 
	{
		List<Criteria> crits = entityMan
				.createQuery("select m from Criteria m where m.id=:id and m.criteriaName=:criteriaName", Criteria.class)
				.setParameter("id", id).setParameter("criteriaName", criteriaName).getResultList();
		if (crits.size() == 1) {
			return crits.get(0);
		}
		return null;
	}

	public Criteria findCrit(int critId) 
	{
		return entityMan.find(Criteria.class, critId);
	}

}