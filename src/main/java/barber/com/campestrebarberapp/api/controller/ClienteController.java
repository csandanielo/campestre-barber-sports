package barber.com.campestrebarberapp.api.controller;

import barber.com.campestrebarberapp.domain.entity.Cliente;
import barber.com.campestrebarberapp.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
