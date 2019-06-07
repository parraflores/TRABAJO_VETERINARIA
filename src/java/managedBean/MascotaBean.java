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
import javax.faces.bean.ManagedBean;
//import javax.enteratprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;

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
        System.out.println("Hola");
        this.mascota=new Mascota();
        
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
  
    public void guardarMascota() {

        try {
            MascotaDao mascotadao = new MascotaDao();
            mascotadao.guardarMascota(mascota);

        } catch (Exception e) {
            System.out.println("error" + e);

        }
    }

    public void actualizarMascota(Mascota mascota) {
        MascotaDao mascotadao = new MascotaDao();
        mascotadao.ActualizarMascota(mascota);

    }

    public ArrayList<Mascota> ListarMascota() {
        MascotaDao mascotadao = new MascotaDao();

        ArrayList<Mascota> lista = new ArrayList<>();
        //lista = mascotadao.listarMascotas(session);
        return lista;
    }

}

    
