package fr.khouya.ejb;

import fr.khouya.beans.HelloBean;

import javax.ejb.Stateless;
import javax.persistence.*;

/**
 * Session Bean implementation class HelloEJB
 */
@Stateless(name = "HelloJNDI")
public class HelloEJB implements HelloEJBRemote, HelloEJBLocal {

    /**
     * Persistence manager
     * */
    @PersistenceContext(unitName = "managerHello")
    EntityManager mh;

    /**
     * Default constructor. 
     */
    public HelloEJB() {
        // TODO Auto-generated constructor stub
    }

    public String direBonjour(String name) {
        System.out.println("Préparation du message pour dire bonjour " + name);
        return "Bonjour " + name;
    }

    public HelloBean direBonjourEntityBean(String name) {
        Query query = mh.createQuery("SELECT h FROM HelloBean h");
        HelloBean helloBean = (HelloBean) query.getSingleResult();
        return helloBean;
    }

    public String direBonjourEntityString(String name) {
        Query q = mh.createQuery("SELECT h.name FROM HelloBean h WHERE h.id=:id")
                .setParameter("id", 1);
        String helloBean = (String) q.getSingleResult();
        return helloBean;
    }

    public String insertIntoTable(String name) {
        HelloBean bean = new HelloBean();
        bean.setName(name);
        mh.persist(bean);
        return name;
    }
}
