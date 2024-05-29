import process.Candidate;
import process.SelectiveProcess;

public class App {
  public static void main(String[] args) {
    Candidate[] candidates = {
        new Candidate("Felipe"),
        new Candidate("Marcia"),
        new Candidate("Julia"),
        new Candidate("Paulo"),
        new Candidate("Augusto"),
        new Candidate("Monica"),
        new Candidate("Fabricio"),
        new Candidate("Mirela"),
        new Candidate("Daniela"),
        new Candidate("Jorge")
    };

    SelectiveProcess selectiveProcess = new SelectiveProcess(candidates);
    selectiveProcess.init();
  }
}
