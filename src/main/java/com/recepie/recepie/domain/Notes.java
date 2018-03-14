package com.recepie.recepie.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recepie recepie;

    @Lob
    private String recepieNotes;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recepie getRecepie() {
        return recepie;
    }

    public void setRecepie(Recepie recepie) {
        this.recepie = recepie;
    }

    public String getRecepieNotes() {
        return recepieNotes;
    }

    public void setRecepieNotes(String recepieNotes) {
        this.recepieNotes = recepieNotes;
    }


}
