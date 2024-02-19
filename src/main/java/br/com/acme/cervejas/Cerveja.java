package br.com.acme.cervejas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data@AllArgsConstructor @NoArgsConstructor @Builder
public class Cerveja {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private String malt;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cerveja cerveja = (Cerveja) o;
        return Objects.equals(name, cerveja.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
