package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.dao.MedioPagoDao;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import java.util.List;


@Service
@Transactional
public class MedioPagoServicioImpl  implements MedioPagoServicio{
    @Inject
    private MedioPagoDao medioPagoDao;

    @Override
    public List<MedioPago> getAll() {
        return medioPagoDao.getAllOrderBy("descripcion");
    }
    
    @Override
	public void add(MedioPago item){
		medioPagoDao.add(item);
	}

	@Override
	public void update(MedioPago item) {
		medioPagoDao.update(item);
	
	}

	
	@Override
	public MedioPago get(Long medioPagoId) {
		MedioPago medioPago=medioPagoDao.find(medioPagoId);
		
		return medioPago;
		
	}
	
	
	@Override
	public Boolean exist(Long medioPagoId) {
		MedioPago medioPago= medioPagoDao.find(medioPagoId);

		return medioPago.getId()>0;	
	}
}
