package school;

import javafx.util.converter.LocalDateStringConverter;
import sun.util.calendar.LocalGregorianCalendar;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SchoolMain {
    /*
    Bem vindo ao cadastro de alunos.
    Escolha uma opção:

    0 - Sair
    1 - Cadastrar novo aluno
    2 - Alterar um aluno
    3 - Listar todos os alunos
    4 - Buscar aluno

    --------- 1
    Matricula:
    <input>
    Nome:
    <input>
    Data De Nascimento:
    <input>
    Nota:
    <input>
    Frequência (%):
    <input>

    ---------- 2
    Matricula do aluno:
    <input>

    Dados do aluno:
    Matricula: 1111111
    Nome: Gabriel Dias Schmoeller
    Data De Nascimento: 15/08/1993
    Nota: 9,9
    Frequência (%): 70%

    Escolha o campo que deseja editar:

    1 - Matricula
    2 - Nome
    3 - Data De Nascimento
    4 - Nota
    5 - Frequência
    <input>

    Digite o novo valor:
    <input>
    ----------- 3
    Ordenar por:

    1 - Matricula
    2 - Nome
    3 - Data De Nascimento
    4 - Nota
    5 - Frequência
    <input>

    Alunos:

    Matricula: 1111111
    Nome: Gabriel Dias Schmoeller
    Data De Nascimento: 15/08/1993
    Nota: 9,9
    Frequência (%): 70%

    Matricula: 0000001
    Nome: Laís Gabrielle Lodi
    Data De Nascimento: 20/09/1988
    Nota: 9,8
    Frequência (%): 100%

    ------------ 4
    Buscar por:

    0 - Qualquer campo
    1 - Matricula
    2 - Nome
    3 - Data De Nascimento
    4 - Nota
    5 - Frequência
    <input>

    Alunos:

    Matricula: 1111111
    Nome: Gabriel Dias Schmoeller
    Data De Nascimento: 15/08/1993
    Nota: 9,9
    Frequência (%): 70%

    Matricula: 0000001
    Nome: Laís Gabrielle Lodi
    Data De Nascimento: 20/09/1988
    Nota: 9,8
    Frequência (%): 100%

     */

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }



}
