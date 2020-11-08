package fr.khouya.ejb;

import fr.khouya.beans.HelloBean;

import javax.ejb.Local;

@Local
public interface HelloEJBLocal {
    String direBonjour(String name);
    HelloBean direBonjourEntityBean(String name);
    String direBonjourEntityString(String name);
    String insertIntoTable(String name);
}
