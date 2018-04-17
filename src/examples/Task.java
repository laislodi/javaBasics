package examples;

public class Task {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public void execute() {
        System.out.println(name);
    }
}
