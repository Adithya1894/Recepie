package com.recepie.recepie.domain;
import javax.persistence.*;
import java.util.Set;

/**
 * Creates a table with the title Entity
 */
@Entity
public class Category {

    /**
     * This is the Id field and it is generated as an identity
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String description;

    //this is mapped many to many and mapped by the column categories
    @ManyToMany(mappedBy = "categories")
    private Set<Recepie> recepies;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recepie> getRecepies() {
        return recepies;
    }

    public void setRecepies(Set<Recepie> recepies) {
        this.recepies = recepies;
    }
}
