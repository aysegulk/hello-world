package kuntakyol.aysegul.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import kuntakyol.aysegul.business.CriteriaService;

import kuntakyol.aysegul.domain.Criteria;


@SuppressWarnings({ "deprecation" })
@ManagedBean
@RequestScoped
public class CritBean {

	private Criteria criteria= new Criteria();
	@EJB
	private CriteriaService criteriaService;

	
	public String createCrit() {
		criteriaService.createCrit(criteria);
		return "Criteria has been defined successfully.";
	}


	public Criteria getCriteria() {
		return criteria;
	}


	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	

}