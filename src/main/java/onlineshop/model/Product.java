package onlineshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;

    @NotNull(message = "Наименование продукта не может быть пустым")
    private String name;

    @NotNull(message = "Описание продукта не может быть пустым")
    private String description;

    private BigDecimal price;

    @Column(name = "quantity_stock")
    private int quantityStock;

}
