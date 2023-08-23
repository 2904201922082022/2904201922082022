// Importar as bibliotecas necessárias
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

// Criar uma classe de teste
public class TestApi4 {

    // Definir a URL da API
    private static final String URL = "dummyjson.com/auth/products";

    // Criar um método de teste
    @Test4
    public void testGet() {

        // Criar um objeto RestTemplate para fazer a requisição HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Criar um objeto HttpHeaders para definir os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Obter o token de autenticação da API
        // Você pode usar o método postForEntity do RestTemplate para fazer uma requisição POST e obter o token como parte da resposta
        // Você deve passar os dados de login (username e password) como um objeto Map e os cabeçalhos como um objeto HttpEntity
        // Você deve extrair o token do corpo da resposta usando um objeto ObjectMapper e armazená-lo em uma variável String
        // Você pode consultar este site para mais detalhes sobre como fazer uma requisição POST com o RestTemplate

        // Criar um objeto Map para armazenar os dados de login
        Map<String, String> loginData = new HashMap<>();
        loginData.put("username", "kminchelle");
        loginData.put("password", "0lelplR");

        // Criar um objeto HttpEntity para encapsular os dados e os cabeçalhos de login
        HttpEntity<Map<String, String>> loginRequest = new HttpEntity<>(loginData, headers);

        // Fazer a requisição POST para a URL 'https://dummyjson.com/auth/login' e obter a resposta como um objeto ResponseEntity
        ResponseEntity<String> loginResponse = restTemplate.postForEntity("https://dummyjson.com/auth/login", loginRequest, String.class);

        // Verificar se o status da resposta de login é 201 OK
        assertEquals(HttpStatus.CREATED, loginResponse.getStatusCode());

        // Criar um objeto ObjectMapper para converter o JSON em objetos Java
        ObjectMapper mapper = new ObjectMapper();

        // Converter o JSON da resposta de login em um mapa
        Map<String, Object> loginUser = mapper.readValue(loginResponse.getBody(), Map.class);

        // Obter o token do mapa e armazená-lo em uma variável String
        String token = (String) loginUser.get("token");

        // Adicionar o token ao cabeçalho de autorização da requisição GET usando o método setBearerAuth do HttpHeaders
        headers.setBearerAuth(token);

        // Criar um objeto HttpEntity para encapsular os cabeçalhos da requisição GET
        HttpEntity<Void> request = new HttpEntity<>(headers);

        // Fazer a requisição GET e obter a resposta como um objeto ResponseEntity usando o método exchange do RestTemplate
        // Você deve passar a URL, o método HTTP, o objeto HttpEntity e a classe do corpo da resposta como parâmetros
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, request, String.class);

        // Verificar se o status da resposta é 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar se o corpo da resposta contém o JSON esperado
        // Criar uma variável para armazenar o JSON esperado
        String expectedJson = "{\"products\": [{\"id\": 1, \"title\": \"iPhone 9\", \"description\": \"An apple mobile which is nothing like apple\", \"price\": 549, \"discountPercentage\": 12.96, \"rating\": 4.69, \"stock\": 94, \"brand\": \"Apple\", \"category\": \"smartphones\", \"thumbnail\": \"https://i.dummyjson.com/data/products/1/thumbnail.jpg\", \"images\": [\"https://i.dummyjson.com/data/products/1/1.jpg\", \"https://i.dummyjson.com/data/products/1/2.jpg\", \"https://i.dummyjson.com/data/products/1/3.jpg\", \"https://i.dummyjson.com/data/products/1/4.jpg\", \"https://i.dummyjson.com/data/products/1/thumbnail.jpg\"]}, {\"id\": 2, \"title\": \"iPhone X\", \"description\": \"SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip with ...\", \"price\": 899, \"discountPercentage\": 17.94, \"rating\": 4.44, \"stock\": 34, \"brand\": \"Apple\", \"category\": \"smartphones\", \"thumbnail\": \"https://i.dummyjson.com/data/products/2/thumbnail.jpg\", \"images\": [\"https://i.dummyjson.com/data/products/2/1.jpg\", \"https://i.dummyjson.com/data/products/2/2.jpg\", \"https://i.dummyjson.com/data/products/2/3.jpg\", \"https://i.dummyjson.com/data/products/2/thumbnail.jpg\"]}, {\"id\": 3, \"title\": \"Samsung Universe 9\", \"description\": \"Samsung's new variant which goes beyond Galaxy to the Universe\", \"price\": 1249, \"discountPercentage\": 15.46, \"rating\": 4.09, \"stock\": 36, \"brand\": \"Samsung\", \"category\": \"smartphones\", \"thumbnail\": \"https://i.dummyjson.com/data/products/3/thumbnail.jpg\", \"images\": [\"https://i.dummyjson.com/data/products/3/1.jpg\"]}], \"total\": 100, \"skip\": 0, \"limit\": 30}";

        // Converter o JSON esperado em um mapa
        Map<String, Object> expectedProducts = mapper.readValue(expectedJson, Map.class);

        // Converter o JSON da resposta em um mapa
        Map<String, Object> actualProducts = mapper.readValue(response.getBody(), Map.class);

        // Comparar os dois mapas usando o método assertEquals
        assertEquals(expectedProducts, actualProducts);
    }
}