import static java.util.Objects.isNull;

public class Main {
    public static void main(String[] args) {
        var numeros = new int[] { 1, 2, 3, 4, 5, 88 };
        var soma = somaNumerosRecursivo(numeros, numeros.length - 1);

        System.out.println("valor da soma é: " + soma);

        var quantidade = contaItensRecursivo(numeros, numeros.length - 1);
        System.out.println("quantidade de itens é: " + quantidade);

        var maiorValor = encontraMaiorValorDaListaRecursivo(numeros, numeros.length - 1, null);
        System.out.println("maior valor é: " + maiorValor);

        var valorPesquisado = pesquisaBinaria(numeros, numeros.length - 1, 88);
        System.out.println(valorPesquisado);

        var valorPesquisado2 = pesquisaBinaria(numeros, numeros.length - 1, 828);
        System.out.println(valorPesquisado2);

        // Saída esperada:
        //  valor da soma é: 103
        //  quantidade de itens é: 6
        //  maior valor é: 88
        //  valor 88 encontrado na posição: 5
        //  valor 828 não encontrado


    }

    //4.1 Escreva o código para a função soma, vista anteriormente.
    public static Integer somaNumerosRecursivo(int[] numeros, int index) {
        if (index < 0) {
            return 0;
        } else {
            return numeros[index] + somaNumerosRecursivo(numeros, index - 1);
        }
    }

    //4.2 Escreva uma função recursiva que conte o número de itens em u m a lista.
    public static Integer contaItensRecursivo(int[] numeros, int index) {
        if (index < 0) {
            return 0;
        } else {
            return 1 + contaItensRecursivo(numeros, index - 1);
        }
    }

    //4.3 Encontre o valor mais alto em uma lista.
    public static Integer encontraMaiorValorDaListaRecursivo(int[] numeros, int index, Integer maiorValor) {
        if(isNull(maiorValor)){
            maiorValor = numeros[index];
        }
        if (index < 0) {
            return maiorValor;
        } else {
            if(numeros[index] > maiorValor){
                maiorValor = numeros[index];
            }
            return encontraMaiorValorDaListaRecursivo(numeros, index - 1, maiorValor);
        }
    }

    //4.4 Você se lembra da pesquisa bináriado Capítulo 1? Ela também é
    //um algoritmo do tipo dividir para conquistar.
    //Você consegue determinar o caso-base e o caso recursivo para a pesquisa binária?
    public static String pesquisaBinaria(int[] numeros, int index, Integer valorPesquisado) {
        if (index < 0) {
            return "valor " + valorPesquisado + " não encontrado";
        } else {
            if(numeros[index] == valorPesquisado){
                return "valor " + valorPesquisado + " encontrado na posição: " + index;
            }
            return pesquisaBinaria(numeros, index - 1, valorPesquisado);
        }
    }


}