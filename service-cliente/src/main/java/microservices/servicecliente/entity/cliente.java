package microservices.servicecliente.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_customers")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder

public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String apellido;

    private Long document;

    private Integer edad;

    private String ciudad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typedocument_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private typedocument typedocument;

    private String estado;
}
