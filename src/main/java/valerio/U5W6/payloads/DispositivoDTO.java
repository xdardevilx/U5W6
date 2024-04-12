package valerio.U5W6.payloads;

import jakarta.validation.constraints.NotEmpty;

public record DispositivoDTO(
        @NotEmpty(message = "deve essere specificato")
        String tipologia,

        @NotEmpty(message = "deve essere specificato")
        String stato
) {
}
