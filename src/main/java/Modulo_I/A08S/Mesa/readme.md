# Exercício Facade pattern

## Objetivo

Fazer o diagrama **UML** e programar em **Java**, implementando o padrão **Facade** comforme o 
seguinte enunciado:

## Enunciado

Quando vamos contratar um serviço de turismo como um voo ou um hotel, temos que
solicitar cada um separadamente. Vamos criar um sistema que nos permita procurar um
hotel e um voo em um mesmo pedido. Para isso será necessário interagir com dois
sistemas.

**Já implementamos** os sistemas de voos e hotéis que possuem a funcionalidade de busca
de acordo com:

- **Busca de voos:** por data de partida, data de retorno, origem e destino.
- **Busca de hotéis:** por data de entrada, data de saída, cidade.

Será implementada uma fachada simples que permite expor um método que realiza as
buscas, tendo o cuidado de interagir com os sistemas de pesquisa e não ter que lidar com
a complexidade dos referidos sistemas a partir do método main.

Você precisa ver na tela quais voos e hotéis estão disponíveis. Os parâmetros de pesquisa
são apenas a cidade do hotel (String), que é a mesma do destino do voo, e as datas
ida-e-volta, que são as mesmas para a pesquisa do voo e do hotel.

O pedido para a fachada, portanto, em uma única chamada inclui as outras duas.

Não se esqueça de implementar os casos de teste necessários a fim de garantir a
qualidade do código produzido.

**Bons estudos!**