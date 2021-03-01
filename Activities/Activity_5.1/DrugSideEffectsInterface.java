public interface DrugSideEffectsInterface {
    public void addDrug(String drug, String[] sideEffects);

    public boolean containsDrug(String drug);

    public String[] getSideEffects(String drug);

    public void display(String drug);
}
