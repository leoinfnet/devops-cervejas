package br.com.acme.cervejas;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
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

    private final MeterRegistry meterRegistry;


    Logger logger = LoggerFactory.getLogger(CervejaController.class);

    public CervejaController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

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
            Counter counter= Counter.builder("quantidade_cervejas_com_erro")
                    .tag("cervejas_com_erro", "erro")
                    .description("Quantidade de cervejas que deram errado")
                    .register(meterRegistry);
            if(valor >= 4800){
                logger.error("O valor é invalido: " +  valor);
                counter.increment();
            }else {
                logger.info("O valor é: " +  valor);
            }
        });
        return ResponseEntity.ok("OK");
    }
    @GetMapping( "/temperatura")
    public ResponseEntity temperaturaDoFreezer(){
        Gauge.builder("temepraturaFreezer", () -> new Random().nextFloat(45))
                .description("A current number of books in the system")
                .register(meterRegistry);
        return ResponseEntity.ok("OK");
    }

}
