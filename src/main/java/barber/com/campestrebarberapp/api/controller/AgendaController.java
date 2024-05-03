package barber.com.campestrebarberapp.api.controller;

import barber.com.campestrebarberapp.api.response.AgendaResponse;
import barber.com.campestrebarberapp.api.response.ClienteResponse;
import barber.com.campestrebarberapp.domain.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService service;

  //  @GetMapping
  //  public ResponseEntity<List<AgendaResponse>> buscarTodos(){
     // todo return
 //   }
}
