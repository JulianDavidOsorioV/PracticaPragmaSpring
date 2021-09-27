package microservices.servicecliente;

import microservices.servicecliente.entity.cliente;
import microservices.servicecliente.entity.typedocument;
import microservices.servicecliente.repository.CustomersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CustomersRepositoryMockTest {

    @Autowired
    private CustomersRepository clienteRepository;
@Test
    public void whenFindByTypedocument_theResturnListProduc(){
        cliente cliente01 = cliente.builder()
                .name("fernando")
                .apellido("garcia")
                .document(Long.parseLong("10"))
                .edad(Integer.parseInt("13"))
                .ciudad("medellin")
                .estado("CREADO")
                .typedocument(typedocument.builder().id(1L).build()).build();
        clienteRepository.save(cliente01);

        List<cliente> founds= clienteRepository.findBytypedocument(cliente01.getTypedocument());

        Assertions.assertEquals(founds.size(), 2);
    }
}
