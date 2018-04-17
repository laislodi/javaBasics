package school.teste;

import school.Aluno;
import school.Application;
import school.datautil.DataUtil;

import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {


    public static void main(String[] args) {
        Aluno aluno1 = new Aluno ("111111","Algum Nome", DataUtil.stringToCalendar("15/09/2012"), 9.5d, 96d);
        Aluno aluno2 = new Aluno ("111112","Outro Nome", DataUtil.stringToCalendar("10/11/2012"), 9.4d, 97d);
        Aluno aluno3 = new Aluno ("111113","Um Outro Nome", DataUtil.stringToCalendar("05/04/2012"), 9.8d, 97d);
        Aluno aluno4 = new Aluno ("111114","Algum Outro Nome", DataUtil.stringToCalendar("08/10/2012"), 9.9d, 98d);

        List<Aluno> alunoList = new ArrayList<>();
        alunoList.add(aluno1);
        alunoList.add(aluno2);
        alunoList.add(aluno3);
        alunoList.add(aluno4);

        Application app = new Application();
        app.listarTodosOsAlunos(alunoList);
    }
}
