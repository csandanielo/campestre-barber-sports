package barber.com.campestrebarberapp.api.mapper;

import barber.com.campestrebarberapp.api.request.ClienteRequest;
import barber.com.campestrebarberapp.api.response.ClienteResponse;
import barber.com.campestrebarberapp.domain.entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final ModelMapper mapper;

    public Cliente toCliente(ClienteRequest request){
        return mapper.map(request, Cliente.class);
    }

    public ClienteResponse toClienteResponse(Cliente cliente){
        return mapper.map(cliente, ClienteResponse.class);
    }

    public  List<ClienteResponse> toClienteResponseList(List<Cliente> clientes) {
        return clientes.stream()
                .map(this::toClienteResponse)
                .collect(Collectors.toList());
        }
}
