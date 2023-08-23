// Importar as bibliotecas necessárias
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

// Criar uma classe principal
public class Main {

    // Criar um método do tipo 'MAIN' como: public static void main(String[]args)
    public static void main(String[] args) {

        // Criar um objeto JUnitCore para executar as classes de teste
        JUnitCore junit = new JUnitCore();

        // Executar as classes de teste e obter o resultado como um objeto Result
        Result result1 = junit.run(TestApi1.class);
        Result result2 = junit.run(TestApi2.class);
        Result result3 = junit.run(TestApi3.class);
        Result result4 = junit.run(TestApi4.class);
        Result result5 = junit.run(TestApi5.class);
        Result result6 = junit.run(TestApi6.class);
        Result result7 = junit.run(TestApi7.class);

        // Imprimir o número de testes executados e o tempo gasto do teste de API 1
        System.out.println("Número de testes executados: " + result1.getRunCount());
        System.out.println("Tempo gasto: " + result1.getRunTime() + " milissegundos");

        // Verificar se houve alguma falha nos testes de API 1 e imprimir os detalhes
        if (result1.getFailureCount() > 0) {
            System.out.println("Número de testes falhados: " + result1.getFailureCount());
            for (Failure failure : result1.getFailures()) {
                System.out.println("Detalhes da falha: " + failure.toString());
            }
        } else {
            System.out.println("Todos os testes passaram com sucesso!");
        }

        // Imprimir o número de testes executados e o tempo gasto do teste de API 2
        System.out.println("Número de testes executados: " + result2.getRunCount());
        System.out.println("Tempo gasto: " + result2.getRunTime() + " milissegundos");

        // Verificar se houve alguma falha nos testes de API 2 e imprimir os detalhes
        if (result2.getFailureCount() > 0) {
            System.out.println("Número de testes falhados: " + result2.getFailureCount());
            for (Failure failure : result2.getFailures()) {
                System.out.println("Detalhes da falha: " + failure.toString());
            }
        } else {
            System.out.println("Todos os testes passaram com sucesso!");
        }
        
        // Imprimir o número de testes executados e o tempo gasto do teste de API 3
        System.out.println("Número de testes executados: " + result3.getRunCount());
        System.out.println("Tempo gasto: " + result3.getRunTime() + " milissegundos");

        // Verificar se houve alguma falha nos testes de API 3 e imprimir os detalhes
        if (result3.getFailureCount() > 0) {
            System.out.println("Número de testes falhados: " + result3.getFailureCount());
            for (Failure failure : result3.getFailures()) {
                System.out.println("Detalhes da falha: " + failure.toString());
            }
        } else {
            System.out.println("Todos os testes passaram com sucesso!");
        }

        // Imprimir o número de testes executados e o tempo gasto do teste de API 4
        System.out.println("Número de testes executados: " + result4.getRunCount());
        System.out.println("Tempo gasto: " + result4.getRunTime() + " milissegundos");

        // Verificar se houve alguma falha nos testes de API 4 e imprimir os detalhes
        if (result4.getFailureCount() > 0) {
            System.out.println("Número de testes falhados: " + result4.getFailureCount());
            for (Failure failure : result4.getFailures()) {
                System.out.println("Detalhes da falha: " + failure.toString());
            }
        } else {
            System.out.println("Todos os testes passaram com sucesso!");
        }

        // Imprimir o número de testes executados e o tempo gasto do teste de API 5
        System.out.println("Número de testes executados: " + result5.getRunCount());
        System.out.println("Tempo gasto: " + result5.getRunTime() + " milissegundos");

        // Verificar se houve alguma falha nos testes de API 5 e imprimir os detalhes
        if (result5.getFailureCount() > 0) {
            System.out.println("Número de testes falhados: " + result5.getFailureCount());
            for (Failure failure : result5.getFailures()) {
                System.out.println("Detalhes da falha: " + failure.toString());
            }
        } else {
            System.out.println("Todos os testes passaram com sucesso!");
        }

        // Imprimir o número de testes executados e o tempo gasto do teste de API 6
        System.out.println("Número de testes executados: " + result6.getRunCount());
        System.out.println("Tempo gasto: " + result6.getRunTime() + " milissegundos");

        // Verificar se houve alguma falha nos testes de API 6 e imprimir os detalhes
        if (result6.getFailureCount() > 0) {
            System.out.println("Número de testes falhados: " + result6.getFailureCount());
            for (Failure failure : result6.getFailures()) {
                System.out.println("Detalhes da falha: " + failure.toString());
            }
        } else {
            System.out.println("Todos os testes passaram com sucesso!");
        }

        // Imprimir o número de testes executados e o tempo gasto do teste de API 7
        System.out.println("Número de testes executados: " + result7.getRunCount());
        System.out.println("Tempo gasto: " + result7.getRunTime() + " milissegundos");

        // Verificar se houve alguma falha nos testes de API 7 e imprimir os detalhes
        if (result7.getFailureCount() > 0) {
            System.out.println("Número de testes falhados: " + result7.getFailureCount());
            for (Failure failure : result7.getFailures()) {
                System.out.println("Detalhes da falha: " + failure.toString());
            }
        } else {
            System.out.println("Todos os testes passaram com sucesso!");
        }
    }
}