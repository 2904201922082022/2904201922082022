// Importar as bibliotecas necessárias
import static org.junit.Assert.*;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

// Criar uma classe de teste
public class TestApi5 {

    // Definir a URL da API
    private static final String URL = "https://dummyjson.com/products/add";

    // Criar um método de teste
    @Test5
    public void testPost() {

        // Criar um objeto RestTemplate para fazer a requisição HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Criar um objeto HttpHeaders para definir os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Criar um objeto Map para armazenar os dados da requisição
        Map<String, Object> data = new HashMap<>();
        data.put("title", "Perfume Oil");
        data.put("description", "Mega Discount, Impression of A...");
        data.put("price", 13);
        data.put("discountPercentage", 8.4);
        data.put("rating", 4.26);
        data.put("stock", 65);
        data.put("brand", "Impression of Acqua Di Gio");
        data.put("category", "fragrances");
        data.put("thumbnail", "https://i.dummyjson.com/data/products/11/thumnail.jpg");

        // Criar um objeto HttpEntity para encapsular os dados e os cabeçalhos da requisição
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(data, headers);

        // Fazer a requisição POST e obter a resposta como um objeto ResponseEntity
        ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);

        // Verificar se o status da resposta é 201 OK
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verificar se o corpo da resposta contém o JSON esperado
        // Criar um objeto ObjectMapper para converter o JSON em objetos Java
        ObjectMapper mapper = new ObjectMapper();

        // Criar uma variável para armazenar o JSON esperado
        String expectedJson = "{\"id\": 101, \"title\": \"Perfume Oil\", \"price\": 13, \"stock\": 65, \"rating\": 4.26, \"thumbnail\": \"https://i.dummyjson.com/data/products/11/thumnail.jpg\", \"description\": \"Mega Discount, Impression of A...\", \"brand\": \"Impression of Acqua Di Gio\", \"category\": \"fragrances\"}";

        // Converter o JSON esperado em um mapa
        Map<String, Object> expectedProduct = mapper.readValue(expectedJson, Map.class);

        // Converter o JSON da resposta em um mapa
        Map<String, Object> actualProduct = mapper.readValue(response.getBody(), Map.class);

        // Comparar os dois mapas usando o método assertEquals
        assertEquals(expectedProduct, actualProduct);
    }
}