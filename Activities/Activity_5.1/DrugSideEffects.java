import java.util.HashMap;

@SuppressWarnings("serial")
public class DrugSideEffects extends HashMap<String, String[]> implements DrugSideEffectsInterface {
    public DrugSideEffects() {
        super();
    }

    public void addDrug(String drug, String[] sideEffects) {
        super.put(drug, sideEffects);
    }

    public boolean containsDrug(String drug) {
        return super.containsKey(drug);
    }

    public String[] getSideEffects(String drug) {
        if (containsDrug(drug)) {
            String[] sideEffects = new String[get(drug).length];

            for (int i = 0; i < get(drug).length; i++)
                sideEffects[i] = get(drug)[i];

            return sideEffects;
        }

        return null;
    }

    public void display(String drug) {
        if (containsDrug(drug)) {
            System.out.println("Drug:\t" + drug);

            System.out.println("Side Effects:");
            for (String sideEffect : getSideEffects(drug))
                System.out.println("\t- " + sideEffect);

            System.out.println();
        } else {
            System.out.println("'" + drug + "'" + " is not found in our database.");
        }
    }
}
