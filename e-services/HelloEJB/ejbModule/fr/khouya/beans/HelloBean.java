package fr.khouya.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "eilco", name = "HelloTable")
public class HelloBean implements Serializable {
	
	private static final long serialVersionUID = 5501721369087808376L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "pk_hello")
	private int id;

    @Column(name = "message")
	private String name = "";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

