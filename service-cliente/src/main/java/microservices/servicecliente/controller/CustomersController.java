package microservices.servicecliente.controller;

import microservices.servicecliente.entity.cliente;
import microservices.servicecliente.entity.typedocument;
import microservices.servicecliente.sevice.CustomersService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping (value = "/customers")
public class CustomersController {

    @Autowired
    private CustomersService clienteService;

    @GetMapping
    public ResponseEntity<List<cliente>> listCliente(@RequestParam(name = "TIid", required = false) Long typedocumentID){
        List<cliente> customer = new ArrayList<>();

        if (null == typedocumentID){
            customer = clienteService.listAllcliente();
            if (customer.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            customer = clienteService.findBytypedocument(typedocument.builder().id(typedocumentID).build());
            if (customer.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.ok(customer);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<cliente> getCliente(@PathVariable("id") Long id){
        cliente customer = clienteService.getcliente(id);
        if (null == customer){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<cliente> createCliente(@RequestBody cliente customer){
        cliente createcliente = clienteService.createcliente(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createcliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<cliente> updateCliente(@PathVariable("id") Long id, @RequestBody cliente Customer){
        Customer.setId(id);
        cliente clientebd= clienteService.updatecliente(Customer);
        if (clientebd == null){
            return  ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(clientebd);
    }

    @DeleteMapping(value =  "/{id}")
    public ResponseEntity<cliente> deleteCliente(@PathVariable("id") Long id){
        cliente clientedeleted = clienteService.deletecliente(id);
        if (clientedeleted == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientedeleted);
    }

}
 