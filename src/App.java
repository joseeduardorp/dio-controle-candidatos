import process.SelectiveProcess;

public class App {
  public static void main(String[] args) {
    String[] candidates = {
        "Felipe",
        "Marcia",
        "Julia",
        "Paulo",
        "Augusto",
        "Monica",
        "Fabricio",
        "Mirela",
        "Daniela",
        "Jorge"
    };

    SelectiveProcess selectiveProcess = new SelectiveProcess(candidates);
    selectiveProcess.init();
  }
}
