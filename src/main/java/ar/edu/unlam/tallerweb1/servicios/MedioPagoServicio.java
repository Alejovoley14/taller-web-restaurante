package ar.edu.unlam.tallerweb1.servicios;
import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;

public interface MedioPagoServicio {
	void add(MedioPago item);
	void update(MedioPago item);
	MedioPago get(Long medioPagoId);
	Boolean exist(Long medioPagoId);
	List<MedioPago> getAll();
}
