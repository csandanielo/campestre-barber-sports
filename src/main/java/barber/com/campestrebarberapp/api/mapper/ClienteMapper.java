package barber.com.campestrebarberapp.api.mapper;

import barber.com.campestrebarberapp.api.request.ClienteRequest;
import barber.com.campestrebarberapp.api.response.ClienteResponse;
import barber.com.campestrebarberapp.domain.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public static Cliente toCliente (ClienteRequest clienteRequest) {

        Cliente cliente = new Cliente ();

    cliente.setNome(clienteRequest.getNome());
    cliente.setSobrenome(clienteRequest.getSobrenome());
    cliente.setEmail(clienteRequest.getEmail());
    cliente.setCpf(clienteRequest.getCpf());
    cliente.setTelefone(clienteRequest.getTelefone());
    cliente.setLoginUsuario(clienteRequest.getLoginUsuario());
    return cliente;
    }

    public static ClienteResponse toClienteResponse (Cliente cliente) {

        ClienteResponse response = new ClienteResponse();

        response.setId(response.getId());
        response.setNome(response.getNome());
        response.setSobrenome(response.getSobrenome());
        response.setEmail(response.getEmail());
        response.setCpf(response.getCpf());
        response.setTelefone(response.getTelefone());
        response.setLoginUsuario(response.getLoginUsuario());
        return response;
    }

    public static List<ClienteResponse> toClienteResponseList(List<Cliente> clientes) {
        List<ClienteResponse> responses = new ArrayList<>();
        for (Cliente cliente : clientes){
            responses.add(toClienteResponse(cliente));
        }
        return responses;
    }
}
