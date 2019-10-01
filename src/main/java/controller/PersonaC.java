package controller;

import dao.PersonaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.PersonaM;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    private PersonaM persona = new PersonaM();
    private List<PersonaM> lstPersona;
    private PersonaM selectedPersona;

    @PostConstruct
    public void iniciar(){
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiar(){
        persona = new PersonaM();
    }
    
    public void add() throws Exception {
        PersonaD dao;
        try {
            dao = new PersonaD();
            dao.agregar(persona);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO CON EXITO"));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO AGREGAR"));
            throw e;
        }
    }
    
    public void listar() throws Exception {
        PersonaD dao;
        try {
            dao = new PersonaD();
            lstPersona = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<PersonaM> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<PersonaM> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public PersonaM getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(PersonaM selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public PersonaM getPersona() {
        return persona;
    }

    public void setPersona(PersonaM persona) {
        this.persona = persona;
    }

}
