package school;

import school.comparator.DataComparator;
import school.comparator.FrequenciaComparator;
import school.comparator.MatriculaComparator;
import school.comparator.NomeComparator;
import school.comparator.NotaComparator;
import school.datautil.DataUtil;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static List<Aluno> alunos = new ArrayList<>();

    public void start() {
        Aluno aluno1 = new Aluno ("111111","Algum Nome", DataUtil.stringToCalendar("20/01/2012"), 9.5d, 96d);
        Aluno aluno2 = new Aluno ("111112","Outro Nome", DataUtil.stringToCalendar("23/12/2012"), 9.4d, 97d);
        Aluno aluno3 = new Aluno ("111113","Um Outro Nome", DataUtil.stringToCalendar("11/04/2012"), 9.8d, 97d);
        Aluno aluno4 = new Aluno ("111114","Algum Outro Nome", DataUtil.stringToCalendar("08/10/2012"), 9.9d, 98d);

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        alunos.add(aluno4);

        System.out.println("Bem vindo ao cadastro de alunos.");
        Integer opcao;
        Aluno aluno;

        do {
            System.out.println("Escolha uma opção:\n");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar novo aluno");
            System.out.println("2 - Alterar um aluno");
            System.out.println("3 - Listar todos os alunos");
            System.out.println("4 - Buscar aluno\n");

            Scanner sc = new Scanner(System.in);
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opcao Invalida.");
                opcao = -1;
            }
            sc.nextLine();

            switch (opcao) {
                case 0: // Sair
                    System.out.println("Então tchau!");
                    break;
                case 1: // Cadastrar novo aluno
                    aluno = criarAluno(sc);
                    alunos.add(aluno);
                    break;
                case 2: // Alterar um aluno
                    System.out.println("Matricula do aluno:");
                    String matricula = sc.nextLine();
                    aluno = buscarAlunoPorMatricula(matricula);
                    if (aluno == null) {
                        System.out.println("Nao ha alunos com esta matricula");
                    } else {
                        System.out.println("Datos do aluno:");
                        System.out.println(aluno.toString());
                        editarAluno(sc, aluno);
                    }
                    break;
                case 3: // Listar todos os alunos
                    listarTodosOsAlunos(alunos);
                    break;
                case 4: // Buscar aluno
                    buscarAlunos(sc);
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public void listarTodosOsAlunos(List<Aluno> alunoList) {
        Scanner scanner = new Scanner(System.in);
        Integer opcao = -1;
        do {
            System.out.println("Ordenar por:");
            System.out.println("1 - Matricula");
            System.out.println("2 - Nome");
            System.out.println("3 - Data de Nascimento");
            System.out.println("4 - Nota");
            System.out.println("5 - Frequencia");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opcao Invalida.");
            }
        } while (opcao < 1 || opcao > 5);

        listarTodosOsAlunos(alunoList, opcao);
    }
    public void listarTodosOsAlunos(List<Aluno> alunoList, int opcao) {
        switch (opcao){
            case 1:
                alunoList.sort(new MatriculaComparator());
                break;
            case 2:
                alunoList.sort(new NomeComparator());
                break;
            case 3:
                alunoList.sort(new DataComparator());
                break;
            case 4:
                alunoList.sort(new NotaComparator());
                break;
            case 5:
                alunoList.sort(new FrequenciaComparator());
                break;
        }
        if (alunoList.isEmpty()) {
            System.out.println("Não foram encontrados alunos.");
        } else {
            System.out.println("Listar todos os alunos");
            for (Aluno aluno : alunoList) {
                System.out.println(aluno.toString());
            }
        }
    }

    public void buscarAlunos(Scanner sc) {
        List<Aluno> alunoList;// = new ArrayList<>();
        System.out.println("Buscar por:");
        System.out.println("0 - Qualquer campo");
        System.out.println("1 - Matricula");
        System.out.println("2 - Nome");
        System.out.println("3 - Data De Nascimento");
        System.out.println("4 - Nota");
        System.out.println("5 - Frequência");

        Integer opcao = -1;
        try {
            opcao = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opcao Invalida.");
        }
        sc.nextLine();
        Aluno aluno;

        switch (opcao){
            case 0:
                System.out.println("Dado:");
                String dado = sc.nextLine();
                alunoList = buscarAlunosPorQualquerCampo(sc, dado);
                listarTodosOsAlunos(alunoList,1);
                break;
            case 1:
                System.out.println("Matricula do aluno:");
                String matricula = sc.nextLine();
                aluno = buscarAlunoPorMatricula(matricula);
                if (aluno != null) {
                    System.out.println(aluno.toString());
                } else {
                    System.out.println("Nenhum aluno encontrado.");
                }
                break;
            case 2:
                System.out.println("Nome do aluno:");
                String nome = sc.nextLine();
                alunoList = buscarAlunosPorNome(nome);
                listarTodosOsAlunos(alunoList,1);
                break;
            case 3:
                System.out.println("Data de Nascimento do aluno:");
                String data = sc.nextLine();
                alunoList = buscarAlunosPorData(data);
                listarTodosOsAlunos(alunoList,1);
                break;
            case 4:
                System.out.println("Nota do aluno:");
                try {
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    String line = sc.nextLine();
                    Double nota = numberFormat.parse(line).doubleValue();
                    alunoList = buscarAlunosPorNota(nota);
                    listarTodosOsAlunos(alunoList,1);
                } catch (ParseException e) {
                    System.out.println("Opcao Invalida.");
                    buscarAlunos(sc);
                }
                break;
            case 5:
                System.out.println("Frequencia do aluno:");
                try {
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    String line = sc.nextLine();
                    Double frequencia = numberFormat.parse(line).doubleValue();
                    alunoList = buscarAlunosPorFrequencia(frequencia);
                    listarTodosOsAlunos(alunoList,1);
                } catch (ParseException e) {
                    System.out.println("Opcao Invalida.");
                    buscarAlunos(sc);
                }
                break;
            default:
                buscarAlunos(sc);
                break;
        }
    }

    public List<Aluno> buscarAlunosPorQualquerCampo(Scanner sc, String dado) {
        List<Aluno> alunoList = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().contains(dado)) {
                alunoList.add(aluno);
            } else if (aluno.getNome().contains(dado)) {
                alunoList.add(aluno);
            } else if (DataUtil.calendarToString(aluno.getDataDeNascimento()).equals(dado)) {
                alunoList.add(aluno);
            } else if (aluno.getFrequencia().toString().equals(dado)) {
                alunoList.add(aluno);
            } else {
                NumberFormat format = NumberFormat.getCurrencyInstance();
                String nota = format.format(aluno.getNota());
                if (nota.equals(dado)) {
                    alunoList.add(aluno);
                }
            }
        }
        return alunoList;
    }

    public List<Aluno> buscarAlunosPorFrequencia(Double frequencia) {
        List<Aluno> alunoList = new ArrayList<>();

        for (Aluno aluno : alunos) {
            if (aluno.getFrequencia().equals(frequencia)) {
                alunoList.add(aluno);
            }
        }

        return alunoList;
    }

    public List<Aluno> buscarAlunosPorNota(Double nota) {
        List<Aluno> alunoList = new ArrayList<>();

        for (Aluno aluno : alunos) {
            if (aluno.getNota().equals(nota)) {
                alunoList.add(aluno);
            }
        }

        return alunoList;
    }

    public List<Aluno> buscarAlunosPorData(String dataDeNascimento) {
        List<Aluno> alunoList = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (DataUtil.calendarToString(aluno.getDataDeNascimento()).contains(dataDeNascimento)) {
                alunoList.add(aluno);
            }
        }
        return alunoList;
    }

    public List<Aluno> buscarAlunosPorNome(String nome) {
        List<Aluno> alunoList = new ArrayList<>();

        for (Aluno aluno : alunos) {
            if (aluno.getNome().contains(nome)) {
                alunoList.add(aluno);
            }
        }
        return alunoList;
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;

    }

    public void editarAluno(Scanner sc, Aluno aluno) {
        alunos.remove(aluno);
        Integer opcao = -1;
        do {
            System.out.println("Escolha o campo que deseja editar:");
            System.out.println("1 - Matricula");
            System.out.println("2 - Nome");
            System.out.println("3 - Data De Nascimento");
            System.out.println("4 - Nota");
            System.out.println("5 - Frequência");

            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opcao Invalida.");
            }
            sc.nextLine();
        } while (opcao < 1 || opcao > 5);
        System.out.print("Nova ");
        switch (opcao) {
            case 1:
                System.out.println("Matricula");
                String matricula = sc.nextLine();
                aluno.setMatricula(matricula);
                break;
            case 2:
                System.out.println("Nome");
                String nome = sc.nextLine();
                aluno.setNome(nome);
                break;
            case 3:
                System.out.println("Data de Nascimento");
                String data = sc.nextLine();
                Calendar dataDeNascimento = DataUtil.stringToCalendar(data);
                aluno.setDataDeNascimento(dataDeNascimento);
                break;
            case 4:
                System.out.println("Nota");
                Double nota = sc.nextDouble();
                aluno.setNota(nota);
                break;
            case 5:
                System.out.println("Frequencia");
                Double frequencia = sc.nextDouble();
                aluno.setFrequencia(frequencia);
                break;
        }
        System.out.println("Novos dados:");
        System.out.println(aluno.toString());
        alunos.add(aluno);
    }

    public Aluno criarAluno(Scanner sc) {

        System.out.println("Cadastrar Aluno:");
        System.out.println("Matricula:");
        String matricula = sc.nextLine();
        System.out.println("Nome:");
        String nome = sc.nextLine();
        System.out.println("Data De Nascimento:");
        String data = sc.nextLine();
        System.out.println("Nota:");
        Double nota = sc.nextDouble();
        System.out.println("Frequência (%):");
        Double frequencia = sc.nextDouble();
        sc.nextLine();

        Calendar dataDeNascimento = DataUtil.stringToCalendar(data);

        Aluno aluno = new Aluno(matricula, nome, dataDeNascimento, nota, frequencia);

        return aluno;
    }
}
