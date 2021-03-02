import java.util.Iterator;

public class Driver {
    public static void main(String args[]) {
        DrugSideEffects drugDatabase = new DrugSideEffects();

        String[] amoxicillin_sideEffects = { "Abdominal or stomach cramps or tenderness", "Back, leg, or stomach pains",
                "Chest pain", "Diarrhea", "Fast heartbeat", "General body swelling", "Headache" };
        String[] lisinopril_sideEffects = { "Blurred vision", "Cloudy urine", "Confusion",
                "Decrease in urine output or decrease in urine-concentrating ability",
                "Dizziness, faintness, or lightheadedness when getting up suddenly from a lying or sitting position sweating",
                "Unusual tiredness or weakness" };

        drugDatabase.addDrug("Amoxicillin", amoxicillin_sideEffects);
        drugDatabase.addDrug("Lisinopril", lisinopril_sideEffects);

        System.out.println("The drug database contains " + drugDatabase.size() + " entries.\n");

        Iterator<String> drugDatabaseIterator = drugDatabase.keySet().iterator();
        while (drugDatabaseIterator.hasNext()) {
            String drug = drugDatabaseIterator.next();
            drugDatabase.display(drug);
        }

        System.out.println("Clearing the drug database...");
        drugDatabase.clear();
        if (drugDatabase.isEmpty())
            System.out.println("Cleared.");
        else
            System.out.println("System failed to clear the drug database.");
    }
}
