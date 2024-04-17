package barber.com.campestrebarberapp.api.controller;

import barber.com.campestrebarberapp.domain.entity.Cliente;
import barber.com.campestrebarberapp.domain.service.ClienteService;
import barber.com.campestrebarberapp.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> salvar (@RequestBody Cliente cliente){
        Cliente clienteSalvo = service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos (){
        List<Cliente> clientes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId (@PathVariable Long id){
        Optional<Cliente> optCliente = service.buscarPorId(id);

        if(optCliente.isEmpty()){
            return ResponseEntity.notFound().build();

        }

        Cliente cliente = optCliente.get();

        return ResponseEntity.status(HttpStatus.OK).body(optCliente.get());

    }

   @PutMapping
   public ResponseEntity<Cliente> alterar (@RequestBody Cliente cliente){
        Cliente clienteSalvo = service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteSalvo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
