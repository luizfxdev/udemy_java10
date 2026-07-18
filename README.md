# Exercício JAVA - Udemy 10

## Exercícios sobre Estrutura Condicional (if/else if/else)

## Sobre o Exercício

Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do jogo, sabendo que o mesmo pode começar em um dia e terminar em outro, tendo uma duração mínima de 1 hora e máxima de 24 horas.

| Entrada | Saída |
|---------|-------|
| 16 e 2 | O jogo durou 10 hora(s) |
| 0 e 0 | O jogo durou 24 hora(s) |
| 2 e 16 | O jogo durou 14 hora(s) |



## Conceitos Principais

### Imports
- `Scanner`: leitura de dados da entrada (teclado)

### Estrutura Condicional
- `if`: testa primeira condição
- `else if`: testa segunda condição (se primeira for falsa)
- `else`: executa se nenhuma anterior for verdadeira

### Três casos de duração

| Caso | Condição | Fórmula |
|------|----------|---------|
| Mesmo horário | `horaFinal == horaInicial` | `duracao = 24` |
| Mesmo dia | `horaFinal > horaInicial` | `duracao = horaFinal - horaInicial` |
| Próximo dia | `horaFinal < horaInicial` | `duracao = 24 - horaInicial + horaFinal` |

### Exemplos de Cálculo

| Inicial | Final | Caso | Resultado |
|---------|-------|------|-----------|
| 16 | 2 | Próximo dia | `24 - 16 + 2 = 10 horas` |
| 0 | 0 | Mesmo horário | `24 horas` |
| 2 | 16 | Mesmo dia | `16 - 2 = 14 horas` |

### try-with-resources
- Garante fechamento automático do Scanner



## Resumo dos Conceitos

- **if/else if/else**: estrutura com múltiplas condições (3+ caminhos)
- **Apenas um bloco executa**: eficiente
- **Horas circulares**: 24h é um ciclo completo
- **Três casos**: mesmo horário, mesmo dia, próximo dia
- **Operadores**: `==` (igualdade), `>` (maior que)
