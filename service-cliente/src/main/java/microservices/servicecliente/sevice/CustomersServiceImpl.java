package microservices.servicecliente.sevice;

import lombok.RequiredArgsConstructor;
import microservices.servicecliente.entity.cliente;
import microservices.servicecliente.entity.typedocument;
import microservices.servicecliente.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public List<cliente> listAllcliente() {
        return customersRepository.findAll();
    }

    @Override
    public cliente getcliente(Long id) {
        return customersRepository.findById(id).orElse(null );
    }

    @Override
    public cliente createcliente(cliente cliente) {
        cliente.setEstado("CREADO");
        return customersRepository.save(cliente);
    }

    @Override
    public cliente updatecliente(cliente Cliente) {
        cliente clienteBD = getcliente(Cliente.getId());
        if (null == clienteBD){
            return null;
        }
        clienteBD.setName(Cliente.getName());
        clienteBD.setEdad(Cliente.getEdad());
        clienteBD.setApellido(Cliente.getApellido());
        clienteBD.setCiudad(Cliente.getCiudad());
        clienteBD.setDocument(Cliente.getDocument());
        clienteBD.setTypedocument(Cliente.getTypedocument());
        return customersRepository.save(clienteBD);
    }

    @Override
    public cliente deletecliente(Long id) {
        cliente clienteBD = getcliente(id);
        if (null == clienteBD){
            return null;
        }
        clienteBD.setEstado("DELETED");
        return customersRepository.save(clienteBD);
    }

    @Override
    public List<cliente> findBytypedocument(typedocument typedocument) {
        return customersRepository.findBytypedocument(typedocument);
    }
}
