package barber.com.campestrebarberapp.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@Table
@Entity
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    private String nomeUsuario;
    private String email;
    private String telefone;
    private String cpf;

    public String getCpf() {
        return cpf;
    }
}
