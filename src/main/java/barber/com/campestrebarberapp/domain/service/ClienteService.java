package barber.com.campestrebarberapp.domain.service;

import barber.com.campestrebarberapp.domain.entity.Cliente;
import barber.com.campestrebarberapp.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar (Cliente cliente){

        if (repository.existsByCpf(cliente.getCpf())) {
            throw new IllegalArgumentException("O CPF já está cadastrado.");
        }

        return repository.save(cliente);

    }

    public List<Cliente> listarTodos(){

        return repository.findAll();

    }

    public Optional<Cliente> buscarPorId(Long id){

        return repository.findById(id);

    }

    public void deletar(Long id){

        repository.deleteById(id);

    }
}
