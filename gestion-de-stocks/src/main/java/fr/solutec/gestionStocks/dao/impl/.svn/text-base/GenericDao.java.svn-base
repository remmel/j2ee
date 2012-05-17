package fr.solutec.gestionStocks.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.solutec.gestionStocks.dao.IGenericDao;

/**
 * Implémentation Hibernate de la couche DAO générique
 * 
 * @author achankimponne
 * 
 */
@Repository("genericDao")
public abstract class GenericDao<T, PK extends Serializable> extends
		HibernateDaoSupport implements IGenericDao<T, PK> {

	/**
	 * La classe de l'objet fille
	 */
	private Class<T> type;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	/**
	 * Initialise la {@link SessionFactory}
	 * 
	 * @param factory
	 */
	@Autowired
	public void init(@Qualifier("sessionFactory") SessionFactory factory) {
		setSessionFactory(factory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.dao.IGenericDao#getById(java.io.Serializable)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public T getById(PK id) {
		return (T) this.getHibernateTemplate().get(type, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.solutec.gestionStocks.dao.IGenericDao#getAll()
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> getAll() {
		return (List<T>) this.getHibernateTemplate().loadAll(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.solutec.gestionStocks.dao.IGenericDao#save(java.lang.Object)
	 */
	@Transactional
	public T save(T o) {
		this.getHibernateTemplate().saveOrUpdate(o);
		return o;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.solutec.gestionStocks.dao.IGenericDao#delete(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(T o) {
		this.getHibernateTemplate().delete(o);
	}

}