package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.ClienteDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Service
@Transactional
public class ClienteServicioImpl implements ClienteServicio {
    @Inject
    private ClienteDao clienteDao;
    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public void add(Cliente item) {
        clienteDao.add(item);
    }

    @Override
    public void update(Cliente item) {
        clienteDao.update(item);
    }

    @Override
    public Cliente get(Long userId) {
        Usuario usuario = usuarioDao.find(userId);
        Collection<Cliente> cliente = usuario.getCliente();
        return cliente.iterator().next();
    }

    @Override
    public Boolean exist(Long userId) {
        Usuario usuario = usuarioDao.find(userId);
        Collection<Cliente> cliente = usuario.getCliente();
        return cliente.isEmpty();
    }
}
