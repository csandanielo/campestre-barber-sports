package barber.com.campestrebarberapp.api.controller;

import barber.com.campestrebarberapp.api.mapper.ClienteMapper;
import barber.com.campestrebarberapp.api.request.ClienteRequest;
import barber.com.campestrebarberapp.api.response.ClienteResponse;
import barber.com.campestrebarberapp.domain.entity.Cliente;
import barber.com.campestrebarberapp.domain.service.ClienteService;
import barber.com.campestrebarberapp.exception.BusinessException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponse> salvar (@Valid @RequestBody ClienteRequest request){
        Cliente cliente = mapper.toCliente(request);
        Cliente clienteSalvo = service.salvar(cliente);
        ClienteResponse clienteResponse = mapper.toClienteResponse(clienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarTodos (){
        List<ClienteResponse> clienteResponses = service.listarTodos()
                .stream()
                .map(mapper::toClienteResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(clienteResponses);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId (@PathVariable Long id){
        Optional<Cliente> optCliente = service.buscarPorId(id);

        if(optCliente.isEmpty()){
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.status(HttpStatus.OK).body(mapper.toClienteResponse(optCliente.get()));

    }

   @PutMapping("/{id}")
   public ResponseEntity<ClienteResponse> alterar (@PathVariable Long id, @RequestBody ClienteRequest request){
        Cliente cliente = mapper.toCliente(request);
        Cliente clienteSalvo = service.salvar(cliente);
        ClienteResponse clienteResponse = mapper.toClienteResponse(clienteSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
