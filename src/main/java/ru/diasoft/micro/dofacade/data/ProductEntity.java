package ru.diasoft.micro.dofacade.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequence")
    @SequenceGenerator(name = "productSequence", sequenceName = "product_seq")
    private Long id;

    @Column(name = "cardNumber", nullable = true)
    public String cardNumber;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "typeName", nullable = false)
    public String typeName;

    @Column(name = "cardStatus", nullable = false)
    public String cardStatus;

    @Column(name = "productType", nullable = false)
    public String productType;

}
