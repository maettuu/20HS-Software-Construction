package shuttleService.behaviors.combustionBehavior;

public class Electric implements CombustionBehavior {

    @Override
    public String getCombustion() {
        return "electric";
    }
}
