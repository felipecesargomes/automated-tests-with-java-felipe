![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)

# Teoria Testes Unitário

Testes unitários são usados para verificar se os métodos de um programa estão funcionando como o previsto e ajudar a identificar bugs nos métodos.

<div align="center">
  <img src="https://github.com/user-attachments/assets/e60d8d59-d8e8-4c2e-9b6a-3399d75e0b90" alt="junit5-removebg-preview">
</div>

## Estrutura de Testes Unitários

Os testes unitários são divididos em três partes principais:

- **Configuração (Given / Arrange)**: Prepare o ambiente para o teste, configurando os dados e o estado inicial necessários.
- **Ação (When / Act)**: Execute a operação ou método que está sendo testado.
- **Verificação (Then / Assert)**: Verifique se o resultado está correto.

## Dependências Externas por MOCK ou Objetos Fakes

Dependências externas de um objeto devem ser substituídas por versões "FAKES", mocks ou stubs durante os testes para isolar a funcionalidade e evitar efeitos colaterais indesejados.

## Quantidade de Testes Unitários por Método

Dependendo da situação, deve-se implementar diversos testes unitários para um único método, por exemplo:
- Teste com parâmetros válidos.
- Teste com parâmetros inválidos.
- Teste para verificar o comportamento com dependências externas, como `HTTPClient`.

## Para que Servem Testes Unitários

Testes unitários são projetados para garantir que cada parte do código funcione corretamente, tanto com parâmetros válidos quanto inválidos. Eles ajudam a identificar bugs e verificar se as funcionalidades estão operando como esperado. Além disso, os testes unitários devem ser mantidos e atualizados conforme o código é alterado. Se uma modificação no código quebra um teste que antes estava funcionando, isso é conhecido como um teste de regressão. Testes de regressão asseguram que novas mudanças no código não introduzam problemas em funcionalidades existentes que já estavam funcionando corretamente.

## Principio F.I.R.S.T
- Fast: Testes unitários que devem executar rapidamente, ou seja, não deve-se comunicar com servidores ou banco de dados remotos.
- Independent – Deve ser independentes uns dos outros e em ordem, então dependências deve ser mockadas.
- Repeatable – Testes unitários devem ser repetíveis, independente de ambiente.
- Self-validating – Os testes unitários deve se auto validarem.
- Thorough e Timely – Os testes unitários deve cobrir casos extremos, forçar parâmetros válidos e inválidos em busca de bugs.
## Testando Código em Isolamento
É importante garantir que precisamos isolar apenas a regra de negócio do método que estamos testando para garantir que o erro não venha de nenhuma dependência que por ventura esse método possui.
É necessário utilizar uma dependência mockada para simular uma injeção de dependência, testando nosso código isoladamente, identificando de onde vem o erro independente de dependências, pois não estamos interessados em testar as dependências, mas sim, a funcionalidade do método.
## Pirâmides de Testes
- Testes unitários: São os o que mais devemos escrever, são rápidos, utilizam de objetos fakes stubs ou mockadas para simular injeção de dependência.
- Testes de integração: Não é usado mocks nem objetos fakes. Envia requisições HTTP (reais) ou manipulando registros no banco de dados se necessário usando conexão real ou requisição real, sendo assim, executado mais lentamente.
- Testes e2e: Testes ponta a ponta, executado lentamente, testando através de clique e entrada nos inputs.

<p align="center">
  <img src="https://github.com/user-attachments/assets/4d8c277b-e906-4be7-b629-98eea1da852e" alt="c4999f4a-8e98-401a-8473-d6a09063f512__1_-removebg-preview">
</p>

## O que é o JUNIT5
É a junção de 3 API’s.
JUnit Plataform + JUnit Jupiter + JUnit Vintage
JUnit Jupiter – A maioria das anotações estão nessa biblioteca.
JUnit Vintage – Compatível para execução de testes escritos em JUnit 3 e JUnit4.


# Resumo dos Tópicos

## Conhecendo as Assertion Messages

Neste tópico, exploramos as *Assertion Messages* em testes. Essas mensagens são usadas para fornecer informações detalhadas quando uma asserção falha. Elas ajudam a identificar rapidamente o motivo de uma falha, tornando o processo de depuração mais eficiente. A prática de usar mensagens claras e descritivas nas asserções é crucial para entender o comportamento dos testes e diagnosticar problemas de forma mais eficaz.

        assertEquals(expected, actual);

## Conhecendo as Lazy Assert Messages

Aqui, discutimos *Lazy Assert Messages*, uma técnica que melhora a performance dos testes. Em vez de avaliar a mensagem de erro imediatamente, ela é avaliada apenas se a asserção falhar. Isso é útil para evitar o custo de criação de mensagens complexas quando os testes passam, otimizando o tempo de execução dos testes. A utilização de mensagens preguiçosas pode tornar a execução dos testes mais eficiente, especialmente quando as mensagens são grandes ou complexas.

        assertEquals(expected, actual, () -> "(" + firstNumber + "/" + secondNumber + ")/2" + " did not produce expected result!");

## Conhecendo a Annotation @DisplayName

        @DisplayName("Test (6.2 + 2)/2 = 4.1")

Este tópico cobre a anotação `@DisplayName` do JUnit 5, que permite fornecer nomes personalizados e mais descritivos para métodos de teste. Em vez de usar os nomes padrão dos métodos, você pode definir nomes mais legíveis e explicativos. Isso melhora a legibilidade dos relatórios de teste e facilita a compreensão do propósito de cada teste. A anotação `@DisplayName` ajuda a criar uma documentação mais clara e compreensível para os testes.

# Ciclo de Vida dos Testes no JUnit

O JUnit define o ciclo de vida dos testes através de anotações que controlam a execução de métodos antes e depois dos testes, além da execução de cada teste. Abaixo está um resumo das principais anotações e o ciclo de vida associado:

## Ciclo de Vida do JUnit

### `@BeforeAll`
- **Propósito**: Executa um método uma vez antes de todos os testes na classe de teste.
- **Uso**: Configuração global necessária para todos os testes. Por exemplo, conectar a um banco de dados ou configurar recursos compartilhados.
- **Requisitos**: O método anotado com `@BeforeAll` deve ser `static`.

```java
@BeforeAll
public static void setup() {
    // Código para configurar recursos necessários antes de qualquer teste
}
```
### `@AfterAll`

- **Propósito**: Executa um método uma vez após todos os testes na classe de teste.
- **Uso**: Limpeza global após todos os testes. Por exemplo, desconectar de um banco de dados ou liberar recursos compartilhados.
- **Requisitos**: O método anotado com @AfterAll deve ser static.

```java
@AfterAll
public static void cleanup() {
    // Código para limpar ou liberar recursos após todos os testes
}
```

### `@BeforeEach`

- **Propósito**: Executa um método antes de cada teste individual.
- **Uso**: Configuração que é específica para cada teste. Por exemplo, inicializar objetos ou definir estados que cada teste precisa.
- **Requisitos**: O método anotado com @BeforeEach não precisa ser static.

```java
@BeforeEach
public void init() {
    // Código para configurar o ambiente de teste antes de cada teste
}
```

### `@AfterEach`

- **Propósito**: Executa um método após cada teste individual.
- **Uso**: Limpeza que é específica para cada teste. Por exemplo, remover dados temporários ou redefinir estados.
- **Requisitos**: O método anotado com @AfterEach não precisa ser static.

```java
@AfterEach
public void tearDown() {
    // Código para limpar o ambiente de teste após cada teste
}
```

### `@Test`

- **Propósito**: Define um método como um caso de teste.
- **Uso**:Contém o código que testa a funcionalidade específica. O método anotado com @Test deve ser public, void, e não pode aceitar argumentos.

```java
@Test
public void testSomething() {
    // Código para verificar a funcionalidade desejada
}
```

@BeforeAll: Executado uma vez antes de todos os testes.<br/>
@BeforeEach: Executado antes de cada teste.<br/>
@Test: O próprio método de teste é executado.<br/>
@AfterEach: Executado após cada teste.<br/>
@AfterAll: Executado uma vez após todos os testes.<br/>

```java
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    @BeforeAll
    public static void setup() {
        // Código de configuração global
    }

    @AfterAll
    public static void cleanup() {
        // Código de limpeza global
    }

    @BeforeEach
    public void init() {
        // Código de configuração antes de cada teste
    }

    @AfterEach
    public void tearDown() {
        // Código de limpeza após cada teste
    }

    @Test
    public void testSomething() {
        // Código do teste
    }
}
```

# Testando Exceções com `assertThrows`

O método `assertThrows` é uma funcionalidade do JUnit 5 que permite testar se uma exceção específica é lançada durante a execução de um bloco de código. Isso é útil para validar comportamentos esperados em situações de erro. 

## Estrutura Básica

```java
assertThrows(
    Class<? extends Throwable> expectedType,
    Executable executable,
    String message
)
```

- **expectedType**: O tipo de exceção que você espera que seja lançada. Normalmente, isso é uma classe que estende Throwable, como ArithmeticException, NullPointerException, etc.
- **executable**: Um bloco de código que você deseja executar e que deve lançar a exceção esperada. Em JUnit 5, isso geralmente é uma expressão lambda ou uma referência a um método.
- **message**: Uma mensagem que será exibida se a asserção falhar. Isso é opcional, mas pode ajudar a diagnosticar por que o teste falhou.

### Exemplo de Uso:

Suponha que você tenha um método que divide dois números e deseja garantir que ele lança uma ArithmeticException quando a divisão por zero é tentada.

```java
public class MathUtils {
    public static double divide(double numerator, double denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numerator / denominator;
    }
}
```

Teste com assertThrows

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    void testDivideByZero() {
        ArithmeticException thrown = assertThrows(
            ArithmeticException.class,
            () -> MathUtils.divide(10, 0),
            "Expected divide by zero to throw, but it didn't"
        );

        assertEquals("Cannot divide by zero", thrown.getMessage(), "Unexpected exception message");
    }
}
```

### Explicação

- O bloco () -> MathUtils.divide(10, 0) é o código que deve lançar a exceção.<br>
- ArithmeticException.class é a classe da exceção que você espera.<br>
- A mensagem fornecida "Expected divide by zero to throw, but it didn't" será exibida se a exceção esperada não for lançada.<br>
- thrown.getMessage() é usado para verificar se a mensagem da exceção corresponde à esperada.<br>

** O assertThrows é uma maneira prática e eficaz de garantir que seu código se comporte conforme o esperado em situações de erro. Utilize-o para verificar a correta gestão de exceções em seus testes. **
