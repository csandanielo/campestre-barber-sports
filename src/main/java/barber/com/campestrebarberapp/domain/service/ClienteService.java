package barber.com.campestrebarberapp.domain.service;

import barber.com.campestrebarberapp.api.response.ClienteResponse;
import barber.com.campestrebarberapp.domain.entity.Cliente;
import barber.com.campestrebarberapp.domain.repository.ClienteRepository;
import barber.com.campestrebarberapp.exception.BusinessException;
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
        
        Optional<Cliente> optCliente = repository.findByCpf(cliente.getCpf());

        boolean existeCpf = false;

        if(optCliente.isPresent()){
            if(!optCliente.get().getId().equals(cliente.getId())){
                existeCpf = true;
            }
        }

        if(existeCpf){
            throw new BusinessException("Cpf já cadastrado");
        }

        return repository.save(cliente);
    }

    public Cliente alterar(Long id, Cliente cliente){
        Optional<Cliente> optCliente = this.buscarPorId(id);

        if(optCliente.isEmpty()){
            throw new BusinessException("Cliente não cadastrado");
        }
        cliente.setId(id);
        return salvar(cliente);
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
