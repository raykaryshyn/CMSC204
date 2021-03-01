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

        drugDatabase.display("Amoxicillin");
        drugDatabase.display("Lisinopril");
    }
}
