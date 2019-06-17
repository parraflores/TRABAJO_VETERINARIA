package interfaces;

import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;

public interface IMascota {

    public abstract boolean guardarMascota(Mascota mascota);

    public abstract ArrayList<Mascota> listarMascotas();

    public abstract boolean ActualizarMascota(Mascota mascota);

    public abstract ArrayList<Mascota> listarRaza(Session sesion);

    public abstract ArrayList<Mascota> listarNombre(Session sesion);

    public abstract Integer CantidadMascota(Session sesion);

    public abstract boolean eliminar(Mascota mascota);
}
