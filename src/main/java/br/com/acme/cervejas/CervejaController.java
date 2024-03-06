package br.com.acme.cervejas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
public class CervejaController {
    @Value("${LOCATION}")
    private String location;
    @Autowired
    CervejaRepository cervejaRepository;
    @Value("${application.name}")
    private String appName;

    Logger logger = LoggerFactory.getLogger(CervejaController.class);
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

    @GetMapping("/name")
    public ResponseEntity hello(){
        return ResponseEntity.ok(Map.of("name", appName));
    }

    @GetMapping("/errors")
    public ResponseEntity<?> getErrors(){
        IntStream.range(0,100).forEach(value -> {
            int valor = new Random().nextInt(5000);

            if(valor >= 4800){
                logger.error("O valor é invalido: " +  valor);
            }else {
                logger.info("O valor é: " +  valor);
            }
        });
        return ResponseEntity.ok("OK");
    }

}
