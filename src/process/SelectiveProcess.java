package process;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SelectiveProcess {
  private String[] candidates = {};
  private final double baseSalary = 2000d;

  public SelectiveProcess(String[] candidates) {
    this.candidates = candidates;
  }

  public void init() {
    ArrayList<String> filteredCandidates = filterCandidates();
    printCandidates(filteredCandidates);
    limiter();
    contactCandidates(filteredCandidates);
  }

  private ArrayList<String> filterCandidates() {
    int currentCandidate = 0;
    ArrayList<String> selectedCandidates = new ArrayList<String>();

    while (selectedCandidates.size() < 5 && currentCandidate < this.candidates.length) {
      String candidate = this.candidates[currentCandidate];
      double salaryExpectation = salaryExpectation();

      if (this.baseSalary >= salaryExpectation) {
        selectedCandidates.add(candidate);
      }

      currentCandidate++;
    }

    return selectedCandidates;
  }

  private void printCandidates(ArrayList<String> candidates) {
    System.out.println("Candidatos selecionados:");

    for (String candidate : candidates) {
      System.out.println("- " + candidate);
    }
  }

  private void contactCandidates(ArrayList<String> candidates) {
    for (String candidate : candidates) {
      callTheCandidate(candidate);
    }
  }

  private void callTheCandidate(String candidate) {
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
      System.out.println("Conseguimos contato com " + candidate + " na " + attempts + "ª tentativa.");
    } else {
      System.out.println("Nâo conseguimos contato com " + candidate + ", número máximo de tentativas excedido!");
    }
  }

  // métodos auxiliares
  private double salaryExpectation() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  private boolean attend() {
    return new Random().nextInt(3) == 1;
  }

  private void limiter() {
    System.out.println("=".repeat(75));
  }
}
