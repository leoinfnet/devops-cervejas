package br.com.acme.cervejas;

import com.github.javafaker.Beer;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;

@SpringBootTest
class CervejasApplicationTests {
	@Autowired
	CervejaRepository cervejaRepository;
	@Test
	void contextLoads() {
		HashSet<Cerveja> cervejas = new HashSet<>();
		for(int i = 1; i<500;i++){
			Faker faker = new Faker();
			Beer beer = faker.beer();
			Cerveja build = Cerveja.builder().name(beer.name())
					.malt(beer.malt()).type(beer.style()).build();
			cervejas.add(build);
		}
		List<Cerveja> list = cervejas.stream().toList();
		System.out.println(list);
		//System.out.println(cervejas.size());
        cervejaRepository.saveAll(list);

	}

}
