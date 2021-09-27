package microservices.servicecliente.sevice;

import microservices.servicecliente.entity.cliente;
import microservices.servicecliente.entity.typedocument;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomersService {
    List<cliente> listAllcliente();
    cliente getcliente(Long id);

    cliente createcliente(cliente cliente);
    cliente updatecliente(cliente cliente);
    cliente deletecliente(Long id);
    List<cliente> findBytypedocument (typedocument typedocument);
}
