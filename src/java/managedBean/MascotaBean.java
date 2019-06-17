/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import java.util.jar.Attributes;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.enteratprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIO
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class MascotaBean {
     Mascota mascota;

    /**
     * Creates a new instance of MascotaBean
     */
    public MascotaBean() {
        
        this.mascota=new Mascota();
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
  
    public String guardarMascota() {

          try {

            MascotaDao mascotadao = new MascotaDao();
           boolean respuesta= mascotadao.guardarMascota(mascota);
           if(respuesta){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Registro Exitoso"));
           }else{
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se Pudo Registar"));
               
           }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return "/index";
    }

    public String actualizarMascota() {
       try {

            MascotaDao mascotadao = new MascotaDao();
           boolean respuesta= mascotadao.ActualizarMascota(mascota);
           if(respuesta){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Registro Exitoso"));
           }else{
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se Pudo Registar"));
               
           }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return "/index";

    }

   public ArrayList<Mascota> ListarMascotas() {
       ArrayList<Mascota> milista = new ArrayList<>();
       MascotaDao dao = new MascotaDao();
       milista= dao.listarMascotas();
       return milista;
    }
    public String limpiar(){
    return "/index.xhtml";
}
public String eliminarMascotas(Mascota mascotas){
 try {

            MascotaDao mascotadao = new MascotaDao();
           boolean respuesta= mascotadao.eliminar(mascotas);
           if(respuesta){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Registro Exitoso"));
           }else{
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se Pudo Registar"));
               
           }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return "/index";
}
}


    
