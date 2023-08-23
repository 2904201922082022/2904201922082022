// Importar as bibliotecas necessárias
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.wiremock.example.util.UserUtil;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

// Criar uma classe de teste
public class TestApi2 {

    // Definir a URL da API
    private static final String URL = "dummyjson.com/users";

    // Criar um método de teste
    @Test2
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

        // Criar uma variável para armazenar o JSON esperado
        String expectedJson = "{\"users\": [{\"id\": 1, \"firstName\": \"Terry\", \"lastName\": \"Medhurst\", \"maidenName\": \"Smitham\", \"age\": 50, \"gender\": \"male\", \"email\": \"
38.1343013,
"lng":
-85.6498512
},
"postalCode":
"40219",
"state":
"KY"
},
"macAddress":
"13:F1:00:DA:A4:12",
"university":
"Stavropol State Technical University",
"bank":
{
"cardExpire":
"10/23",
"cardNumber":
"5355920631952404",
"cardType":
"mastercard",
"currency":
"Ruble",
"iban":
"MD63 L6YC 8YH4 QVQB XHIK MTML"
},
}
"package com.wiremock.example;
    }
}

public class UserControllerTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void listUsers() throws Exception {

        // Criar um objeto ObjectMapper para converter objetos em JSON
        ObjectMapper mapper = new ObjectMapper();

        // Definir um stub para o endpoint /users
        stubFor(get(urlEqualTo("/users"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(UserUtil.getUsersJson())));

        // Fazer uma requisição GET para o endpoint /users
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8089/users", String.class);

        // JSON esperado
        String expectedJson = UserUtil.getUsersJson();

        // Converter o JSON esperado em uma lista de mapas
        List<Map<String, Object>> expectedUsers = mapper.readValue(expectedJson, new TypeReference<List<Map<String, Object>>>() {});

        // Converter o JSON da resposta em uma lista de mapas
        List<Map<String, Object>> actualUsers = mapper.readValue(response.getBody(), new TypeReference<List<Map<String, Object>>>() {});

        // Comparar as duas listas de mapas usando o método assertArrayEquals
        assertArrayEquals(expectedUsers.toArray(), actualUsers.toArray());
    }
}