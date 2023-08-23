// Importar as bibliotecas necessárias
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

// Criar uma classe de teste
public class TestApi1 {

    // Definir a URL da API
    private static final String URL = "dummyjson.com/test";

    // Criar um método de teste
    @Test1
    public void testGet() {

        // Criar um objeto RestTemplate para fazer a requisição HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Fazer a requisição GET e obter a resposta como um objeto ResponseEntity
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        // TESTE 1: Verificar se o status da resposta é 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar se o corpo da resposta contém o JSON esperado
        assertEquals("{\"status\": \"ok\", \"method\": \"GET\"}", response.getBody());
        
        // TESTE 2: Verificar se o status da resposta é 404 ERRO
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        // Verificar se o corpo da resposta contém o JSON esperado
        assertEquals("{\"status\": \"ERRO\", \"method\": \"GET\"}", response.getBody());

        // TESTE 3: Verificar se o status da resposta é 403 Forbidden (TOKEN INVALIDO)
        assertEquals(HttpStatus.INVALID_TOKEN, response.getStatusCode());

        // Verificar se o corpo da resposta contém o JSON esperado
        assertEquals("{\"status\": \"Forbidden\", \"method\": \"GET\"}", response.getBody());
    }
}