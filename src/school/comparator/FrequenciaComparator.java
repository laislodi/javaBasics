package school.comparator;

import school.Aluno;

import java.util.Comparator;

public class FrequenciaComparator implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return -a1.getFrequencia().compareTo(a2.getFrequencia());
    }
}