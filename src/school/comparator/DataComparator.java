package school.comparator;

import school.Aluno;

import java.util.Comparator;

public class DataComparator implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a1.getDataDeNascimento().compareTo(a2.getDataDeNascimento());
    }
}
