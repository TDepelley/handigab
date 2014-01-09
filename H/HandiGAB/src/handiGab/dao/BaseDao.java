package handiGab.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

/**
 * @author Fatoumata BA
 * @param <T>
 * @param <PK>
 */
public interface BaseDao <T, PK extends Serializable>{

    /**
     * -------------------------------------------------------------------------------------------------------------------------
     * Methode generique utilisee pour lire tous les objets dans type particulier. Qui correspond a tous les lignes d'une table.
     * -------------------------------------------------------------------------------------------------------------------------
     */
    List<T> findAll();

    /**
     * --------------------------------------------------------------------------------------------------
     * Methode generique utilisee pour lire un objet dans une classe en utilisant sa cle primaire. 
     * Un ObjectRetrievalFailureException Runtime Exception est declenchee s'il n'ya pas d'enregistrement
     * --------------------------------------------------------------------------------------------------
     */
    T get(PK id);

    /**
     * ---------------------------------------------------------------------------------------------------
     * Methode generique utilisee pour verifier l'existence d'un object de type T utilisant l'argument id.
     * ---------------------------------------------------------------------------------------------------
     */
    boolean exists(PK id);

    /**
     * ----------------------------------------------------------------------------------------------
     * Methode generique utilisee pour sauvegarder un objet. elle fait la mise a jour ou l'insertion.
     * ----------------------------------------------------------------------------------------------
     */
    T saveOrUpdate(T object, PK id) ;

    /**
     * --------------------------------------------------------------------------------
     * Methode generique utilisee pour supprimer un object base sur une classe et un id
     * --------------------------------------------------------------------------------
     */
    void remove(PK id);
    
    /**
     * -------------------------------------------------
     * Cette methode permette d'executer une requete HQL
     * -------------------------------------------------  
     */
    public Query getHqlQuery(String req);
    
    /**
     * -------------------------------------------------
     * Cette methode permette d'executer une requete SQL
     * -------------------------------------------------  
     */
    public Query getSqlQuery(String req);
    
    /**
     * -----------------------------------------------------
     * Cette methode permet d'execute une requete NamedQuery
     * -----------------------------------------------------
     */
    public Query getNamedQuery(String req);
}
