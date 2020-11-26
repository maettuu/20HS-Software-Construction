package shuttleService.behaviors.combustionBehavior;

/**
 * Electric Combustion
 */
public class Electric implements CombustionBehavior {

    /**
     * Always returns "electric"
     * @return string with described behaviour
     */
    @Override
    public String getCombustion() {
        return "electric";
    }
}
