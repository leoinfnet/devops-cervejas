package br.com.acme.cervejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class CervejaController {
    @Value("${LOCATION}")
    private String location;
    @Autowired
    CervejaRepository cervejaRepository;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(cervejaRepository.findAll());
    }
    @GetMapping("/file")
    public ResponseEntity<?> getFromFile(){

        Path path = Paths.get(location);
        List<String> strings = new ArrayList<>();
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(strings);
    }

}
