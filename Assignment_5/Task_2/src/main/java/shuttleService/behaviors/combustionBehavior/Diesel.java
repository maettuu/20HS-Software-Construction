package shuttleService.behaviors.combustionBehavior;

/**
 * Diesel Combustion
 */
public class Diesel implements CombustionBehavior {

    /**
     * Always returns "diesel"
     * @return string with described behaviour
     */
    @Override
    public String getCombustion() {
        return "diesel";
    }
}
