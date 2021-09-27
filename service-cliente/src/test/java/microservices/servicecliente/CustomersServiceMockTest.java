package microservices.servicecliente;

import microservices.servicecliente.entity.cliente;
import microservices.servicecliente.entity.typedocument;
import microservices.servicecliente.repository.CustomersRepository;
import microservices.servicecliente.sevice.CustomersService;
import microservices.servicecliente.sevice.CustomersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CustomersServiceMockTest {

    @Mock
    private CustomersRepository clienteRepository;

    private CustomersService clienteservice;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        clienteservice = new CustomersServiceImpl( clienteRepository);
        cliente customer = cliente.builder()
                .id(1L)
                .name("federico")
                .apellido("puerta")
                .document(Long.parseLong("1006324599"))
                .edad(Integer.parseInt("13"))
                .ciudad("holanda")
                .typedocument(typedocument.builder().id(2L).build())
                .estado("CREADO")
                .build();

        Mockito.when(clienteRepository.findById(1L))
                .thenReturn(Optional.of(customer));

        Mockito.when(clienteRepository.save(customer))
                .thenReturn(customer);
    }

    @Test
    public void whenValidGetID_ThenReturnCliente(){
        cliente found = clienteservice.getcliente(1L);
        Assertions.assertEquals(found.getName(), "federico");
    }
    @Test
    public  void whenListAllCustomers_ThenReturnListCustomers(){
        List<cliente> found= clienteservice.listAllcliente();
    }
    @test
    public void when
}
