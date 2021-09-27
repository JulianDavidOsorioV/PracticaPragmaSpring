package microservices.servicecliente.repository;

import microservices.servicecliente.entity.cliente;
import microservices.servicecliente.entity.typedocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<cliente, Long> {

    public List<cliente> findBytypedocument(typedocument typedocument);
}
