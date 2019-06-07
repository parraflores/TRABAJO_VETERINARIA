
package pruebas;

import Dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

public class Ejemplo2 {

    public static void main(String[] args) {
        ArrayList<Mascota> lista=new ArrayList<>();
        MascotaDao mascotadao=new MascotaDao();
        Session sesion=HibernateUtil.getSessionFactory().openSession();
     lista = mascotadao.listarMascotas(sesion);
        
        for (Mascota mascota : lista) {
            //JOptionPane.showMessageDialog(null, mascota.getNombreMascota());
            System.out.print(mascota.getNombreMascota());
        }
    }
    
}
