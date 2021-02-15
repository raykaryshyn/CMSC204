/**
 * Runs a simulation of a random constrained customer line with WaitLine.
 * 
 * @author Raymond Karyshyn
 */

public class RunSimulation {
    public static void main(String[] args) {
        WaitLine customerLine = new WaitLine();

        // Simulate the line for 30 min with a 40% arrival possibility
        // and a 6 min maximum transaction time.
        customerLine.simulate(30, 0.4, 6);
        customerLine.displayResults();
    }
}
