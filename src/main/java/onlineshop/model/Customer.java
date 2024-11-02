package onlineshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int customerId;

    @Column(name = "first_name")
    @NotNull(message = "Имя покупателя не может быть пустым")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Фамилия покупателя не может быть пустой")
    private String lastName;

    @NotNull(message = "Заполните поле с email")
    @Email(message = "Введите корректную форму электронного адреса")
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;
}
