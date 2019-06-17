
package Dao;

import entidades.Mascota;
import interfaces.IMascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author Lenovo
 */
public class MascotaDao implements IMascota {

    @Override
    public boolean guardarMascota(Mascota mascota) {
        //construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //registrar en la base de datos de la 
        try {
            sesion.save(mascota);
            transaccion.commit();

        } catch (Exception e) {
            System.out.println("error"+e);
        }
 
        sesion.close();
        return respuesta;

    }


    @Override
    public ArrayList<Mascota> listarMascotas() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Mascota> milista = new ArrayList<>();

        //crear la consulta hacia la base de datos
        Query query = sesion.createQuery("FROM Mascota");

        //ejecutar la consulta y obtener la lista
        milista = (ArrayList<Mascota>) query.list();
        return milista;
    }

    @Override
    public boolean ActualizarMascota(Mascota mascota) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //registrar en la base de datos de la 
        try {
            sesion.update(mascota);
            transaccion.commit();

        } catch (Exception e) {
            System.out.println("error"+e);
        }
 
        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Mascota> listarRaza(Session sesion) {
      	String hql ="FROM Mascota where raza='Pastor Aleman'";        
        Query query = sesion.createQuery(hql);
        List< Mascota > lista= (List< Mascota >) query.list();
	return (ArrayList<Mascota>) lista;

    }

    @Override
    public ArrayList<Mascota> listarNombre(Session sesion) {
     	String hql ="FROM Mascota where nombreMascota='Sandor'";        
        Query query = sesion.createQuery(hql);
        List< Mascota > lista= (List< Mascota >) query.list();
	return (ArrayList<Mascota>) lista;
    }

    @Override
    public Integer CantidadMascota(Session sesion) {
         String hql = "select count(*) from Mascota";
        Query query = sesion.createQuery(hql);
        Long FilasTab=(Long) query.uniqueResult();
        Integer cont=FilasTab.intValue();
        return cont;
    }

    @Override
    public boolean eliminar(Mascota mascota) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        boolean respuesta = true;
        try{
        sesion.delete(  mascota);
        transaccion.commit();
        }catch(Exception e){
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }
    
    }

