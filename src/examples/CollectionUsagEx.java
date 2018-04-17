package examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CollectionUsagEx {

    public static void main(String[] args) {
        arrayEx();
        listEx();
        setEx();
        queueEx();
        mapEx();
    }

    /**
     * Exemplos matemáticos e matrizes
     */
    private static void arrayEx() {
        // Conjunto de valores pré definidos
        Integer[] axys = new Integer[2];

        axys[0] = 22;
        axys[1] = 35;

        System.out.println("Eixo x: " + axys[0] + ", Eixo y: " + axys[1]);

        // Matriz de 2x3
        Pessoa[][] salaDeAula = new Pessoa[5][6];
        salaDeAula[0][0] = new Pessoa("João", 15);
        salaDeAula[1][2] = new Pessoa("Paulo", 16);
        salaDeAula[0][1] = new Pessoa("Ana", 16);

        System.out.println("Quem esta sentado na linha 1 coluna 2: " + salaDeAula[0][1]);
    }

    /**
     * Uso geral
     */
    private static void listEx() {
        List<Pessoa> listaDeChamada = new ArrayList<>();
        listaDeChamada.add(new Pessoa("Gabriel", 13));
        listaDeChamada.add(new Pessoa("Sophia", 14));
        listaDeChamada.add(new Pessoa("Miguel", 12));

        System.out.println("Quem é o melhor aluno da sala: " + listaDeChamada.get(1) + " e " + listaDeChamada.get(2));

    }

    /**
     * Set é usado pra garantir unicidade e operações de conjunto - União, Intercessão, Diferença, Contém, etc
     */
    private static void setEx() {
        Set<Pessoa> matriculadosMatematica = new HashSet<>();
        matriculadosMatematica.add(new Pessoa("Sophia", 14));
        matriculadosMatematica.add(new Pessoa("Gabriel", 13));

        Set<Pessoa> matriculadosPortugues = new HashSet<>();
        matriculadosPortugues.add(new Pessoa("Gabriel", 13));
        matriculadosPortugues.add(new Pessoa("Miguel", 12));

        Set<Pessoa> matriculadosPtMt = new HashSet<>(matriculadosPortugues);
        matriculadosPtMt.retainAll(matriculadosMatematica);

        System.out.println("Alunos que estão em matematica e em portugues: " + matriculadosPtMt);

        Set<Pessoa> matriculadosApenasPt = new HashSet<>(matriculadosPortugues);
        matriculadosApenasPt.removeAll(matriculadosMatematica);

        System.out.println("Alunos que não estão em matematica e em portugues: " + matriculadosApenasPt);

        // testar se duas listas são iguais:

        List<Pessoa> lista1 = new ArrayList<>();
        lista1.add(new Pessoa("Gabriel", 13));
        lista1.add(new Pessoa("Sophia", 14));
        lista1.add(new Pessoa("Miguel", 12));

        List<Pessoa> lista2 = new ArrayList<>();
        lista2.add(new Pessoa("Gabriel", 13));
        lista2.add(new Pessoa("Sophia", 14));
        lista2.add(new Pessoa("Miguel", 12));

        Set<Pessoa> lista1Copy = new HashSet<>(lista1);
        lista1Copy.addAll(lista2);

        if (lista1Copy.size() == lista1.size()){
            System.out.println("Listas contém os mesmos elementos.");
        }else{
            System.out.println("Há elementos diferentes");
        }
    }

    /**
     * Filas e geral, quando a ordem é importante
     */
    private static void queueEx() {
        Queue<Task> tasks = new LinkedList<>();

        tasks.add(new Task("Inicializa ambiente"));
        tasks.add(new Task("inicializa scripts"));
        tasks.add(new Task("Executando tarefas whatever"));

        tasks.poll().execute();
        tasks.poll().execute();
        tasks.poll().execute();
    }

    /**
     * Principais usos:
     * agrupar elementos.
     * mapear elementos por um ou mais atributos muito usados em buscas - Normalmente são criadas classes como keys para facilitar buscas0
     */
    private static void mapEx() {
        List<Cadastro> cadastroPessoas = new ArrayList<>();
        cadastroPessoas.add(new Cadastro("00000000001", "Gabriel", 13));
        cadastroPessoas.add(new Cadastro("00000000002", "Sophia", 14));
        cadastroPessoas.add(new Cadastro("00000000003", "Miguel", 12));
        cadastroPessoas.add(new Cadastro("00000000004", "Miguel", 14));
        cadastroPessoas.add(new Cadastro("00000000005", "Gabriel", 13));

        // por nome
        Map<String, List<Cadastro>> mesmoNome = new HashMap<>();
        for (Cadastro pessoa : cadastroPessoas) {
            if (!mesmoNome.containsKey(pessoa.getNome())) {
                mesmoNome.put(pessoa.getNome(), new ArrayList<>());
            }
//            ou
//            mesmoNome.putIfAbsent(pessoa.getNome(), new ArrayList<>());

            mesmoNome.get(pessoa.getNome()).add(pessoa);
        }

        System.out.println("Pessoas agrupadas por nome: ");
        printPrettyPrisioner(mesmoNome);

        // por idade
        Map<Integer, List<Cadastro>> mesmaIdade = new HashMap<>();
        for (Cadastro pessoa : cadastroPessoas) {
            mesmaIdade.putIfAbsent(pessoa.getIdade(), new ArrayList<>());
            mesmaIdade.get(pessoa.getIdade()).add(pessoa);
        }

        System.out.println("Pessoas agrupadas por idade: ");
        printPrettyPrisioner(mesmaIdade);

        // por nome e idade iguais
        // mapeamento de classe (key) para lista
        Map<Pessoa, List<Cadastro>> mesmoNomeIdade = new HashMap<>();
        for (Cadastro pessoa : cadastroPessoas) {
            Pessoa key = new Pessoa(pessoa.getNome(),pessoa.getIdade());
            mesmoNomeIdade.putIfAbsent(key, new ArrayList<>());
            mesmoNomeIdade.get(key).add(pessoa);
        }
        System.out.println("Pessoas agrupadas por nome e idade:");
        printPrettyPrisioner(mesmoNomeIdade);

        // mapear cpf por cadastro para otimizar buscas
        Map<String, Cadastro> cadastrosPorCpf = new HashMap<>();
        for (Cadastro pessoa : cadastroPessoas) {
            cadastrosPorCpf.put(pessoa.getCpf(), pessoa);
        }

        System.out.println(cadastrosPorCpf.get("00000000005"));
    }

    private static void printPrettyPrisioner(Map<?, List<Cadastro>> mesmoNome) {
        for (Map.Entry<?, List<Cadastro>> entry : mesmoNome.entrySet()) {
            System.out.print("\n" + entry.getKey() + ": ");
            for (Cadastro cadastro : entry.getValue()) {
                System.out.print(cadastro);
            }
        }
    }
}
