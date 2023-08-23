// Importar as bibliotecas necessárias
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

// Criar uma classe de teste
public class TestApi7 {

    // Definir a URL da API
    private static final String URL = "dummyjson.com/products/";

    // Criar um método de teste
    @Test7
    public void testGet() {

        // Criar um objeto RestTemplate para fazer a requisição HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Definir o id do produto que queremos obter
        int id = 1;

        // Fazer a requisição GET e obter a resposta como um objeto ResponseEntity
        ResponseEntity<String> response = restTemplate.getForEntity(URL + id, String.class);

        // Verificar se o status da resposta é 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar se o corpo da resposta contém o JSON esperado
        // Criar um objeto ObjectMapper para converter o JSON em objetos Java
        ObjectMapper mapper = new ObjectMapper();

        // Criar uma variável para armazenar o JSON esperado
        String expectedJson = "{\"id\": 1, \"title\": \"iPhone 9\", \"description\": \"An apple mobile which is nothing like apple\", \"price\": 549, \"discountPercentage\": 12.96, \"rating\": 4.69, \"stock\": 94, \"brand\": \"Apple\", \"category\": \"smartphones\", \"thumbnail\": \"https://i.dummyjson.com/data/products/1/thumbnail.jpg\", \"images\": [\"https://i.dummyjson.com/data/products/1/1.jpg\", \"https://i.dummyjson.com/data/products/1/2.jpg\", \"https://i.dummyjson.com/data/products/1/3.jpg\", \"https://i.dummyjson.com/data/products/1/4.jpg\", \"https://i.dummyjson.com/data/products/1/thumbnail.jpg\"]}";

        // Converter o JSON esperado em um mapa
        Map<String, Object> expectedProduct = mapper.readValue(expectedJson, Map.class);

        // Converter o JSON da resposta em um mapa
        Map<String, Object> actualProduct = mapper.readValue(response.getBody(), Map.class);

        // Comparar os dois mapas usando o método assertEquals
        assertEquals(expectedProduct, actualProduct);
    }
}