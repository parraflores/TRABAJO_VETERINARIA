
package pruebas;

import Dao.MascotaDao;
import entidades.Mascota;


public class Ejemplo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          MascotaDao mascotadao =new MascotaDao();
        Mascota mimascota=new Mascota(2, "Bony", "Lusmery", "Pastor Aleman");
        
        mascotadao.ActualizarMascota(mimascota);
    }
    
}
