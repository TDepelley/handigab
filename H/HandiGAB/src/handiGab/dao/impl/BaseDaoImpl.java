package handiGab.dao.impl;

import handiGab.dao.BaseDao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.ObjectRetrievalFailureException;


/**
 * @author Fatoumata BA
 * c'est la classe de base d'implementation de tous les  DAOs 
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
    /**
     * Log variable pour tous les sous classes.
     */
    protected final Log log = LogFactory.getLog(getClass());
    private Class<T> persistentClass;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    public BaseDaoImpl(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    /**
     * -------------------------------------------------------------------------------------------------------------------------
     * Methode generique utilisee pour lire tous les objets dans type particulier. Qui correspond a tous les lignes d'une table.
     * -------------------------------------------------------------------------------------------------------------------------
     */
    @SuppressWarnings("unchecked")
	public List<T> findAll() 
	{
        return (List<T>) getSessionFactory().getCurrentSession().createQuery("from "+this.persistentClass).list();
    }

    /**
     * --------------------------------------------------------------------------------------------------
     * Methode generique utilisee pour lire un objet dans une classe en utilisant sa cle primaire. 
     * Un ObjectRetrievalFailureException Runtime Exception est declenchee s'il n'ya pas d'enregistrement
     * --------------------------------------------------------------------------------------------------
     */
    public T get(PK id) 
    {
    	if(id==null)
    	{
    		return null;
    	}
    	else
    	{
        @SuppressWarnings("unchecked")
		T entity = (T) getSessionFactory().getCurrentSession().get(this.persistentClass, id);
        if (entity == null) 
        {
            log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }
        return entity;
    	}
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Methode generique utilisee pour verifier l'existence d'un object de type T utilisant l'argument id.
     * ---------------------------------------------------------------------------------------------------
     */
    public boolean exists(PK id) 
    {
        if(id == null)
        {
        	return false;
        }
        else
        {
        	@SuppressWarnings("unchecked")
        	T entity = (T) getSessionFactory().getCurrentSession().get(this.persistentClass, id);
        	return entity != null;
        }
    }

    /**
     * ----------------------------------------------------------------------------------------------
     * Methode generique utilisee pour sauvegarder un objet. elle fait la mise a jour ou l'insertion.
     * ----------------------------------------------------------------------------------------------
     */
	public T saveOrUpdate(T object, PK id) 
	{
    	if(this.exists(id))
		{
			getSessionFactory().getCurrentSession().update(object);
		}
    	
		else
		{
			getSessionFactory().getCurrentSession().save(object);
		}
    	
		return this.get(id);
    }

	/**
     * --------------------------------------------------------------------------------
     * Methode generique utilisee pour supprimer un object base sur une classe et un id
     * --------------------------------------------------------------------------------
     */
    public void remove(PK id) 
    {
    	getSessionFactory().getCurrentSession().delete(this.get(id));
    }

    /**
     * -------------------------------------------------
     * Cette methode permette d'executer une requete HQL
     * -------------------------------------------------  
     */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
    public Query getHqlQuery(String req)
    {
    	return getSessionFactory().getCurrentSession().createQuery(req);
    }
    
    /**
     * -------------------------------------------------
     * Cette methode permette d'executer une requete SQL
     * -------------------------------------------------  
     */
    public Query getSqlQuery(String req)
    {
    	return getSessionFactory().getCurrentSession().createSQLQuery(req);
    }
    
    /**
     * -----------------------------------------------------
     * Cette methode permet d'execute une requete NamedQuery
     * -----------------------------------------------------
     */
    public Query getNamedQuery(String req)
    {
    	return getSessionFactory().getCurrentSession().getNamedQuery(req);
    }
}