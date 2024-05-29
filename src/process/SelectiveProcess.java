package process;

import java.util.ArrayList;
import java.util.Random;

public class SelectiveProcess {
  private Candidate[] candidates = {};
  private final double baseSalary = 2000d;

  public SelectiveProcess(Candidate[] candidates) {
    this.candidates = candidates;
  }

  public void init() {
    ArrayList<Candidate> filteredCandidates = filterCandidates();
    printCandidates(filteredCandidates);
    limiter();
    contactCandidates(filteredCandidates);
  }

  private ArrayList<Candidate> filterCandidates() {
    int currentCandidate = 0;
    ArrayList<Candidate> selectedCandidates = new ArrayList<Candidate>();

    while (selectedCandidates.size() < 5 && currentCandidate < this.candidates.length) {
      Candidate candidate = this.candidates[currentCandidate];
      double salaryExpectation = candidate.getSalaryExpectation();

      if (this.baseSalary >= salaryExpectation) {
        selectedCandidates.add(candidate);
      }

      currentCandidate++;
    }

    return selectedCandidates;
  }

  private void printCandidates(ArrayList<Candidate> candidates) {
    printTitle("Candidatos selecionados:");

    for (Candidate candidate : candidates) {
      System.out.println("- " + candidate.getName());
    }
  }

  private void contactCandidates(ArrayList<Candidate> candidates) {
    printTitle("Tentando contato com os candidatos:");

    for (Candidate candidate : candidates) {
      callTheCandidate(candidate);
    }
  }

  private void callTheCandidate(Candidate candidate) {
    int attempts = 1;
    boolean keepTrying = true;
    boolean attendedTo = false;

    do {
      attendedTo = attend();
      keepTrying = !attendedTo;

      if (keepTrying) {
        attempts++;
      }
    } while (keepTrying & attempts < 3);

    if (attendedTo) {
      System.out.println("Conseguimos contato com " + candidate.getName() + " na " + attempts + "ª tentativa.");
    } else {
      System.out
          .println("Nâo conseguimos contato com " + candidate.getName() + ", número máximo de tentativas excedido!");
    }
  }

  // métodos auxiliares
  private boolean attend() {
    return new Random().nextInt(3) == 1;
  }

  private void limiter() {
    System.out.println("=".repeat(75));
  }

  private void printTitle(String title) {
    System.out.println(title);
    System.out.println("-".repeat(title.length()));
  }
}
