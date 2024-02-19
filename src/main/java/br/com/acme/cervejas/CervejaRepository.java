package br.com.acme.cervejas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CervejaRepository extends JpaRepository<Cerveja,Long> {
}
