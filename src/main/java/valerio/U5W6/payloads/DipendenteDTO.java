package valerio.U5W6.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record DipendenteDTO(
        @NotEmpty(message = "il nome è obbligatorio")
        String name,
        @NotEmpty(message = "il cognome è obbligatorio")
        String surname,

        @NotEmpty(message = "l'username è obbligatorio")
        String username,

        @NotEmpty(message = "l'email è obbligatoria")
        @Email(message = "l'email non è valida")
        String email,

        String profileImg

) {
}
