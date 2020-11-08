package fr.khouya.ejb;

import fr.khouya.beans.HelloBean;

import javax.ejb.Remote;

@Remote
public interface HelloEJBRemote {
    String direBonjour(String name);
    HelloBean direBonjourEntityBean(String name);
    String direBonjourEntityString(String name);
    String insertIntoTable(String name);
}
