// Importar as bibliotecas necessárias
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

// Criar uma classe de teste
public class TestApi3 {

    // Definir a URL da API
    private static final String URL = "https://dummyjson.com/auth/login";

    // Criar um método de teste
    @Test3
    public void testPost() {

        // Criar um objeto RestTemplate para fazer a requisição HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Criar um objeto HttpHeaders para definir os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Criar um objeto Map para armazenar os dados da requisição
        Map<String, String> data = new HashMap<>();
        data.put("username", "kminchelle");
        data.put("password", "0lelplR");

        // Criar um objeto HttpEntity para encapsular os dados e os cabeçalhos da requisição
        HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

        // Fazer a requisição POST e obter a resposta como um objeto ResponseEntity
        ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);

        // Verificar se o status da resposta é 201 OK
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verificar se o corpo da resposta contém o JSON esperado
        // Criar um objeto ObjectMapper para converter o JSON em objetos Java
        ObjectMapper mapper = new ObjectMapper();

        // Criar uma variável para armazenar o JSON esperado
        String expectedJson = "{\"id\": 15, \"username\": \"kminchelle\", \"email\": \"kminchelle@qq.com\", \"firstName\": \"Jeanne\", \"lastName\": \"Halvorson\", \"gender\": \"female\", \"image\": \"https://robohash.org/autquiaut.png\", \"token\": \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZyIsImlhdCI6MTY4MjY5MTgwMSwiZXhwIjoxNjgyNjk1NDAxfQ.npaLt2FFWCh6PAR9cUrufmmI6uLebd2Q6SFMHy8EZ1M\"}";

        // Converter o JSON esperado em um mapa
        Map<String, Object> expectedUser = mapper.readValue(expectedJson, Map.class);

        // Converter o JSON da resposta em um mapa
        Map<String, Object> actualUser = mapper.readValue(response.getBody(), Map.class);

        // Comparar os dois mapas usando o método assertEquals
        assertEquals(expectedUser, actualUser);
    }
}