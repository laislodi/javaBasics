package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class CollectionEx {

    public static void main(String[] args) {
        arrayEx();
        listEx();
        setEx();
        queueEx();
        mapEx();
    }

    /**
     * Caracteristicas de array:
     * Inicializa com o tamanho fixo
     * insere em posição específica
     * recupera acessando a posição específica
     */
    private static void arrayEx() {
        System.out.println("\nArray:");

        // inicializa
        String[] array = new String[4];

        // adiciona
        array[0] = "Alguma coisa";
        array[1] = "Outra coisa";

        // exibe todos
        System.out.println(Arrays.toString(array));

        // retorna especifico
        System.out.println(array[1]);
    }

    /**
     * Características de list:
     * não possui tamanho pré definido
     * insere no final da lista
     * insere em uma posição especifica
     * garante ordem
     * recupera acessando a posição específica
     */
    private static void listEx() {
        System.out.println("\nList:");

        // inicializa
        List<String> lista = new ArrayList<>();

        // adiciona
        lista.add("Coisinha 1");
        lista.add("Coisinha 3");
        lista.add("Coisinha 4");
        lista.add(1, "Coisinha 2");

        // exibe todos
        System.out.println(lista);

        // retorna especifico
        System.out.println(lista.get(3));
    }

    /**
     * Características do Set:
     * não possui tamanho pré definido
     * insere com add
     * garante unicidade
     * * critério de unicidade é definido pela classe inserida
     * recupera através de iteração
     */
    private static void setEx() {
        System.out.println("\nSet:");

        // inicializa
        Set<Pessoa> conjunto = new HashSet<>();

        // adiciona
        conjunto.add(new Pessoa("Coisinha 1", 10));
        conjunto.add(new Pessoa("Coisinha 2", 10));
        conjunto.add(new Pessoa("Coisinha 3", 10));
        conjunto.add(new Pessoa("Coisinha 2", 11));

        // exibe todos
        System.out.println(conjunto);

        // retorna especifico
        for (Pessoa pessoa : conjunto) {
            if (pessoa.getNome().equals("Coisinha 3")) {
                System.out.println(pessoa);
            }
        }

    }

    /**
     * Características de uma Queue
     * náo possui tamanho pré-definido
     * insere no final da fila (usando add)
     * o primeiro elemento a ser inserido é o primeiro a ser recuperado
     * recupera em ordem de inserção
     */
    private static void queueEx() {
        System.out.println("\nQueue:");

        // inicializa
        Queue<String> fila = new LinkedBlockingDeque<>();
        fila.add("Coisa 2");
        fila.add("Coisa");
        fila.add("Coisa 3");

        // exibe todos
        System.out.println(fila);

        // retorna especifico
        System.out.println(fila.poll());
    }

    /**
     * Características de um Map:
     * Inicializa sem tamanho pré-definido
     * Relaciona uma chave a um valor (quaisquer tipos)
     * insere sem ordenação, localiza e recupera pela chave:
     * * chave não pode ser repetida
     * * valor pode ser repetido
     * Devem ser implementados os métodos equals e hashcode.
     * * equals  : método verifica se duas instâncias de uma classe são iguais.
     * * * Duas instâncias com mesmos atributos devem gerar o mesmo hascode.
     * * HashCode: método que gera um número que identifica uma instância de uma classe (deve ser único, mas não é garantido)
     * * * Duas instâncias com mesmos valores de atributos podem - porém não devem - gerar o mesmo hascode.
     */
    private static void mapEx() {
        System.out.println("\nMap:");

        // inicializa
        Map<Pessoa, Integer> mapa = new HashMap<>();

        // exibe todos
        mapa.put(new Pessoa("bolo", 1), 100);
        mapa.put(new Pessoa("pudim", 2), 20);
        mapa.put(new Pessoa("biscoito", 3), 5);
        mapa.put(new Pessoa("torta", 4), 8000);

        // exibe todos
        System.out.println(mapa);

        // retorna especifico
        System.out.println(mapa.get(new Pessoa("pudim", 2)));

        // iterar por todos os valores
        System.out.println("iterar nas chaves:");
        for (Pessoa chave : mapa.keySet()) {
            System.out.println(chave);
        }
        System.out.println("iterar nos valores:");
        for (Integer valor : mapa.values()) {
            System.out.println(valor);
        }
        System.out.println("iterar nas entradas:");
        for (Map.Entry<Pessoa, Integer> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
