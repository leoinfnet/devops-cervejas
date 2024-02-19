package br.com.acme.cervejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CervejaController {
    @Autowired
    CervejaRepository cervejaRepository;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(cervejaRepository.findAll());
    }
}
