
package pruebas;

import Dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;
import utilitarios.HibernateUtil;


public class Ejemplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                  ArrayList<Mascota> lista=new ArrayList<>();
        MascotaDao mascotadao=new MascotaDao();
        Session sesion=HibernateUtil.getSessionFactory().openSession();
     lista = mascotadao.listarNombre(sesion);
        
        for (Mascota mascota : lista) {
            //JOptionPane.showMessageDialog(null, mascota.getNombreMascota());
            System.out.print(mascota.getNombreMascota() +"\t \t");
            System.out.print(mascota.getMascotaCliente()+"\t \t");
            System.out.println(mascota.getRaza());
           
        }
    }
    
}
