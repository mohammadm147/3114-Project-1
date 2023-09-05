public class Command {

    public String command;
    public String id;
    public Seminar seminar;

    public Command(String inputCommand, String inputId) {
        command = inputCommand;
        id = inputId;
    }


    public Command(String inputCommand, String inputId, Seminar sem) {
        command = inputCommand;
        id = inputId;
        seminar = sem;
    }
}
