// Importar as bibliotecas necessárias
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import java.net.URI;
import java.util.Map;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;

// Criar uma classe de teste
public class TestApi6 {

    // Definir a URL da API
    private static final String URL = "http://dummyjson.com/products";

    // Criar um método de teste
    @Test6
    public void testGet() {

        // Criar um objeto RestTemplate para fazer a requisição HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Fazer a requisição GET e obter a resposta como um objeto ResponseEntity
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        // Verificar se o status da resposta é 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar se o corpo da resposta contém o JSON esperado
        // Criar um objeto ObjectMapper para converter o JSON em objetos Java
        ObjectMapper mapper = new ObjectMapper();

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
{
"id":
4,
"title":
"OPPOF19",
"description":
"OPPO F19 is officially announced on April 2021.",
"price":
280,
"discountPercentage":
17.91,
"rating":
4.3,
"stock":
123,
"brand":
"OPPO",
"category":
"smartphones",
"thumbnail":
"https://i.dummyjson.com/data/products/4/thumbnail.jpg",
"images":
[
"https://i.dummyjson.com/data/products/4/1.jpg",
"https://i.dummyjson.com/data/products/4/2.jpg",
"https://i.dummyjson.com/data/products/4/3.jpg",
"https://i.dummyjson.com/data/products/4/4.jpg",
"https://i.dummyjson.com/data/products/4/thumbnail.jpg"
]
},
{
"id":
5,
"title":
"Huawei P30",
"description":
"Huawei’s re-badged P30 Pro New Edition was officially unveiled yesterday in Germany and now the device has made its way to the UK.",
"price":
499,
"discountPercentage":
10.58,
"rating":
4.09,
"stock":
32,
"brand":
"Huawei",
"category":
"smartphones",
"thumbnail":
"https://i.dummyjson.com/data/products/5/thumbnail.jpg",
"images":
[
"https://i.dummyjson.com/data/products/5/1.jpg",
"https://i.dummyjson.com/data/products/5/2.jpg",
"https://i.dummyjson.com/data/products/5/3.jpg"
]
}],
\"total\": 100, \"skip\": 0, \"limit\": 5}";

package br.com.alura.loja;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ProductsApiTest {

    @Test6
    public void test() throws Exception {
        TestRestTemplate client = new TestRestTemplate();
        RequestEntity<Void> request = new RequestEntity<Void>(HttpMethod.GET, new URI("/produtos"));
        ResponseEntity<String> response = client.exchange(request, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Converter o JSON esperado em um mapa
        Map<String, Object> expectedProducts = new ObjectMapper().readValue(expectedJson, Map.class);

        // Converter o JSON da resposta em um mapa
        Map<String, Object> actualProducts = new ObjectMapper().readValue(response.getBody(), Map.class);

        // Comparar os dois mapas usando o método assertEquals
        assertEquals(expectedProducts, actualProducts);
    }
}