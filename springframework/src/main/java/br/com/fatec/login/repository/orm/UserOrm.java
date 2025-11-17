package br.com.fatec.login.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public record UserOrm(
        @Id
        String id,
        @Indexed
        String username,
        String password,
        String email
) {
}
