package process;

import java.util.concurrent.ThreadLocalRandom;

public class Candidate {
  private String name;
  private double salaryExpectation;

  public Candidate(String name) {
    this.name = name;
    this.salaryExpectation = salaryExpectation();
  }

  private double salaryExpectation() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalaryExpectation() {
    return salaryExpectation;
  }

  public void setSalaryExpectation(double salaryExpectation) {
    this.salaryExpectation = salaryExpectation;
  }
}
