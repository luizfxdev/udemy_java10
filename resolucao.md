# Explicação do Programa: Cálculo da Duração do Jogo

## Código atual

```java
import java.util.Scanner;

public class DuracaoJogo {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int horaInicial = sc.nextInt();
            int horaFinal = sc.nextInt();
            
            int duracao;
            
            if (horaFinal == horaInicial) {
                duracao = 24;
            }
            else if (horaFinal > horaInicial) {
                duracao = horaFinal - horaInicial;
            }
            else {
                duracao = 24 - horaInicial + horaFinal;
            }
            
            System.out.println("O jogo durou " + duracao + " hora(s)");
        }
    }
}
```

---

## Análise linha por linha

### `import java.util.Scanner;`
Importa a classe `Scanner` do pacote `java.util`. Necessária para ler dados da entrada (teclado).

### `public class DuracaoJogo {`
Define a classe `DuracaoJogo`. O arquivo deve se chamar `DuracaoJogo.java`.

### `public static void main(String[] args) {`
Método principal, ponto de entrada da aplicação.

### `try (Scanner sc = new Scanner(System.in)) {`
Cria um Scanner chamado `sc`, apontando para a entrada padrão (teclado).

Usa `try-with-resources` para garantir fechamento automático do Scanner.

### `int horaInicial = sc.nextInt();`
Lê a **hora inicial** do jogo (inteiro de 0 a 23).

### `int horaFinal = sc.nextInt();`
Lê a **hora final** do jogo (inteiro de 0 a 23).

### `int duracao;`
Declara a variável `duracao` (será calculada posteriormente).

---

## ?? Conceito: if/else if/else

### Estrutura com múltiplas condições

Este programa usa **três condições diferentes** (três caminhos possíveis):

```java
if (condicao1) {
    // caminho 1
}
else if (condicao2) {
    // caminho 2
}
else {
    // caminho 3 (padrão)
}
```

**Importante:** Apenas **um** bloco será executado.
- Se `condicao1` for verdadeira ? executa bloco 1
- Se `condicao1` for falsa **E** `condicao2` for verdadeira ? executa bloco 2
- Se ambas forem falsas ? executa bloco 3 (else)

---

## Lógica do programa: Três casos de duração

### Caso 1: Hora final = Hora inicial (mesmo valor)

```java
if (horaFinal == horaInicial) {
    duracao = 24;
}
```

**Exemplo:** Começa 0h, termina 0h

**Significado:** Jogo começou em um dia e terminou no dia seguinte na mesma hora ? **24 horas**.

**Valores possíveis:**
- Começa 0h, termina 0h ? 24 horas
- Começa 5h, termina 5h ? 24 horas
- Começa 23h, termina 23h ? 24 horas

**Por que 24?** Se começou e terminou no mesmo horário, só pode ter sido 24 horas (passou um dia inteiro).

---

### Caso 2: Hora final > Hora inicial (mesmo dia)

```java
else if (horaFinal > horaInicial) {
    duracao = horaFinal - horaInicial;
}
```

**Exemplo:** Começa 2h, termina 16h

**Significado:** Jogo começou e terminou no **mesmo dia**.

**Cálculo:** `duracao = 16 - 2 = 14 horas`

**Valores possíveis:**
- Começa 2h, termina 16h ? 14 horas
- Começa 10h, termina 20h ? 10 horas
- Começa 1h, termina 23h ? 22 horas

**Lógica:** Se terminou depois de começar no mesmo dia, basta subtrair.

---

### Caso 3: Hora final < Hora inicial (próximo dia)

```java
else {
    duracao = 24 - horaInicial + horaFinal;
}
```

**Exemplo:** Começa 16h, termina 2h

**Significado:** Jogo começou em um dia e **terminou no dia seguinte**.

**Cálculo:**
```
duracao = 24 - 16 + 2
duracao = 8 + 2
duracao = 10 horas
```

**Explicação do cálculo:**
- De 16h até meia-noite (00h) = `24 - 16 = 8 horas`
- De meia-noite (00h) até 2h = `2 horas`
- Total = `8 + 2 = 10 horas`

**Valores possíveis:**
- Começa 20h, termina 4h ? `24 - 20 + 4 = 8 horas`
- Começa 23h, termina 3h ? `24 - 23 + 3 = 4 horas`
- Começa 18h, termina 10h ? `24 - 18 + 10 = 16 horas`

---

## Representação visual da duração

### Caso 1: horaFinal == horaInicial

```
Dia 1                  Dia 2
????????????????????????????????????????
? 00:00h        ...        00:00h      ?
? Início                    Fim        ?
????????????????????????????????????????
  ?????????? 24 horas ??????????
```

---

### Caso 2: horaFinal > horaInicial

```
Dia 1
????????????????????????????????
? 02:00h      ...      16:00h  ?
? Início                Fim    ?
????????????????????????????????
  ???????? 14 horas ????????
```

---

### Caso 3: horaFinal < horaInicial

```
Dia 1                  Dia 2
???????????????????????????????????????
? 16:00h   ...     ? 00:00h  ...  2h  ?
? Início           ?        Fim       ?
???????????????????????????????????????
  ??? 8 horas ??????? 2 horas ???
  ???????????? 10 horas total ??????????
```

---

## Fluxo de execução

```
???????????????????????????????????
? java DuracaoJogo                ?
???????????????????????????????????
             ?
???????????????????????????????????
? Scanner criado                  ?
???????????????????????????????????
             ?
???????????????????????????????????
? Lê: horaInicial                 ?
? Lê: horaFinal                   ?
???????????????????????????????????
             ?
???????????????????????????????????
? Testa: horaFinal == horaInicial??
???????????????????????????????????
             ?
        ???????????
       SIM       NÃO
        ?         ?
   duracao=24  Testa: horaFinal > horaInicial?
        ?       ?              ?
        ?      SIM            NÃO
        ?       ?              ?
        ?    duracao=     duracao=24-
        ?    horaFinal-   horaInicial+
        ?    horaInicial  horaFinal
        ?    ?              ?
        ?????????????????????
             ?
???????????????????????????????????
? Imprime duracao                 ?
???????????????????????????????????
             ?
???????????????????????????????????
? Scanner fecha automaticamente    ?
???????????????????????????????????
```

---

## Exemplos de execução

### Exemplo 1: horaInicial = 16, horaFinal = 2 (PRÓXIMO DIA)

```
java DuracaoJogo
16
2
```

**Processamento:**
1. `horaInicial = 16`
2. `horaFinal = 2`
3. Testa: `horaFinal == horaInicial` ? ? `2 == 16` ? **NÃO**
4. Testa: `horaFinal > horaInicial` ? ? `2 > 16` ? **NÃO**
5. Executa `else`: `duracao = 24 - 16 + 2 = 10`
6. Imprime: `O jogo durou 10 hora(s)`

**Saída:**
```
O jogo durou 10 hora(s)
```

**Explicação:** Jogo começou 16h, terminou 2h do dia seguinte ? 10 horas

---

### Exemplo 2: horaInicial = 0, horaFinal = 0 (MESMO HORÁRIO)

```
java DuracaoJogo
0
0
```

**Processamento:**
1. `horaInicial = 0`
2. `horaFinal = 0`
3. Testa: `horaFinal == horaInicial` ? ? `0 == 0` ? **SIM**
4. Executa `if`: `duracao = 24`
5. Imprime: `O jogo durou 24 hora(s)`

**Saída:**
```
O jogo durou 24 hora(s)
```

**Explicação:** Começou meia-noite, terminou meia-noite do dia seguinte ? 24 horas

---

### Exemplo 3: horaInicial = 2, horaFinal = 16 (MESMO DIA)

```
java DuracaoJogo
2
16
```

**Processamento:**
1. `horaInicial = 2`
2. `horaFinal = 16`
3. Testa: `horaFinal == horaInicial` ? ? `16 == 2` ? **NÃO**
4. Testa: `horaFinal > horaInicial` ? ? `16 > 2` ? **SIM**
5. Executa `else if`: `duracao = 16 - 2 = 14`
6. Imprime: `O jogo durou 14 hora(s)`

**Saída:**
```
O jogo durou 14 hora(s)
```

**Explicação:** Jogo começou 2h e terminou 16h do mesmo dia ? 14 horas

---

## Tabela de análise

| Inicial | Final | Caso | Fórmula | Resultado |
|---------|-------|------|---------|-----------|
| 16 | 2 | Próximo dia | `24 - 16 + 2` | **10 horas** |
| 0 | 0 | Mesmo horário | `24` | **24 horas** |
| 2 | 16 | Mesmo dia | `16 - 2` | **14 horas** |
| 20 | 4 | Próximo dia | `24 - 20 + 4` | **8 horas** |
| 10 | 20 | Mesmo dia | `20 - 10` | **10 horas** |
| 23 | 23 | Mesmo horário | `24` | **24 horas** |

---

## if/else if/else vs múltiplos if

### ? Errado: usar múltiplos `if` independentes

```java
if (horaFinal == horaInicial) {
    duracao = 24;
}
if (horaFinal > horaInicial) {  // ? Sempre testa
    duracao = horaFinal - horaInicial;
}
if (horaFinal < horaInicial) {  // ? Sempre testa
    duracao = 24 - horaInicial + horaFinal;
}
```

**Problema:** Todas as condições são testadas, mesmo que a primeira já seja verdadeira. Pode sobrescrever o valor.

### ? Correto: usar if/else if/else

```java
if (horaFinal == horaInicial) {
    duracao = 24;
}
else if (horaFinal > horaInicial) {  // ? Só testa se anterior falso
    duracao = horaFinal - horaInicial;
}
else {  // ? Padrão se nenhuma anterior foi verdadeira
    duracao = 24 - horaInicial + horaFinal;
}
```

**Vantagem:** Eficiente, apenas um bloco é executado.

---

## Precedência de operadores

```java
duracao = 24 - horaInicial + horaFinal;
```

**Ordem de execução:**
1. `-` (subtração) - da esquerda para direita
2. `+` (adição)

Equivalente a:
```java
duracao = (24 - horaInicial) + horaFinal;
```

---

## Resumo dos conceitos

- **if/else if/else**: estrutura com **múltiplas condições** (3+ caminhos)
- **Apenas um bloco executa**: eficiente, evita redundância
- **Casos de duração**: mesmo horário (24h), mesmo dia (subtração), próximo dia (fórmula)
- **Lógica de horas circulares**: 24h é um ciclo (0h = 24h)
- **Concatenação**: `"O jogo durou " + duracao + " hora(s)"`
- **try-with-resources**: gerencia fechamento automático de recursos

---

## Diferença com exercícios anteriores

| Exercício | Condições | Estrutura |
|-----------|-----------|-----------|
| 7-8 | 2 caminhos | `if/else` |
| 9 | 2 condições com OR | `if/else` com `\|\|` |
| 10 (este) | **3+ caminhos** | **`if/else if/else`** |

---

## Variações possíveis

### Com validação de entrada

```java
if (horaInicial < 0 || horaInicial > 23 || horaFinal < 0 || horaFinal > 23) {
    System.out.println("Hora invalida!");
}
else if (horaFinal == horaInicial) {
    duracao = 24;
}
else if (horaFinal > horaInicial) {
    duracao = horaFinal - horaInicial;
}
else {
    duracao = 24 - horaInicial + horaFinal;
}
```

### Com switch (alternativa)

```java
int comparacao = horaFinal == horaInicial ? 0 : (horaFinal > horaInicial ? 1 : 2);
switch (comparacao) {
    case 0:
        duracao = 24;
        break;
    case 1:
        duracao = horaFinal - horaInicial;
        break;
    case 2:
        duracao = 24 - horaInicial + horaFinal;
        break;
}
```

### Com mensagem mais descritiva

```java
String periodo;

if (horaFinal == horaInicial) {
    duracao = 24;
    periodo = "um dia inteiro";
}
else if (horaFinal > horaInicial) {
    duracao = horaFinal - horaInicial;
    periodo = "no mesmo dia";
}
else {
    duracao = 24 - horaInicial + horaFinal;
    periodo = "em dias diferentes";
}

System.out.println("O jogo durou " + duracao + " hora(s) " + periodo);
```

---

## Diagrama de decisão

```
              ????????????????????????
              ? Ler horas: Ini, Fim  ?
              ????????????????????????
                         ?
              ??????????????????????????
              ? Fim == Ini ?           ?
              ?????????????????????
                        SIM      NÃO
                        ?        ?
                   duracao=24  Fim > Ini ?
                        ?     ?        ?
                        ?    SIM      NÃO
                        ?     ?        ?
                        ?  duracao= duracao=
                        ?  Fim-Ini  24-Ini+Fim
                        ?  ?        ?
                        ?????????????
                           ?
              ????????????????????????????
              ? Imprime: "O jogo durou X ?
              ?         hora(s)"         ?
              ????????????????????????????
                         ?
                      ????????
                      ? FIM  ?
                      ????????
```

---


