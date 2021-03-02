public interface DrugSideEffectsInterface {
    public void addDrug(String drug, String[] sideEffects);

    public String[] removeDrug(String drug);

    public boolean containsDrug(String drug);

    public String[] addSideEffects(String drug, String[] sideEffects);

    public String[] getSideEffects(String drug);

    public void display(String drug);

    public int size();

    public void clear();

    public boolean isEmpty();
}
