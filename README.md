# Teoria Testes Unitário

Testes unitários são usados para verificar se os métodos de um programa estão funcionando como o previsto e ajudar a identificar bugs nos métodos.

<p align="center">
![junit5-removebg-preview](https://github.com/user-attachments/assets/e60d8d59-d8e8-4c2e-9b6a-3399d75e0b90)
</p>

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
![c4999f4a-8e98-401a-8473-d6a09063f512__1_-removebg-preview](https://github.com/user-attachments/assets/4d8c277b-e906-4be7-b629-98eea1da852e)
</p>

## O que é o JUNIT5
É a junção de 3 API’s.
JUnit Plataform + JUnit Jupiter + JUnit Vintage
JUnit Jupiter – A maioria das anotações estão nessa biblioteca.
JUnit Vintage – Compatível para execução de testes escritos em JUnit 3 e JUnit4.
