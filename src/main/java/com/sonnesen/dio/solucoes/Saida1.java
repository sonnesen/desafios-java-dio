package com.sonnesen.dio.solucoes;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
O seu instrutor de lógica de programação, Damilson Bonetti, quer que você desenvolva uma tela com as seguintes
características:

    1. Conter 39 traços horizontais ( - ) na primeira linha;
    2. Conter um traço vertical ( | ) embaixo do primeiro traço e do trigésimo nono traço da primeira linha, preencher
       no meio com espaço em branco;
    3. Repita o procedimento 2 quatro vezes;
    4. Repita o procedimento 1.

No final deve ficar igual a imagem a seguir:

--------------------------------------- (39 traços)
|                                     |
|                                     |
|                                     |
|                                     |
|                                     |
--------------------------------------- (39 traços)

Entrada
Não há.

Saída
A saída será impresso conforme a figura acima.

Exemplo de Entrada 	Exemplo de Saída
                    ---------------------------------------

                    |                                     |

                    |                                     |

                    |                                     |

                    |                                     |

                    |                                     |

                    ---------------------------------------
*/
public class Saida1 {

    public static void main(String[] args) {
        char charToFill = '-';
        int length = 39;

        String linhaTracejada = Stream.generate(() -> String.valueOf(charToFill)).limit(length).collect(Collectors.joining());
        String linhaComBarra = "|" + Stream.generate(() -> String.valueOf(" ")).limit(length - 2).collect(Collectors.joining()) + "|";

        for (int i = 0; i < 7; i++) {
            if (i == 0 || i == 6) System.out.println(linhaTracejada);
            else System.out.println(linhaComBarra);
        }
    }
}
