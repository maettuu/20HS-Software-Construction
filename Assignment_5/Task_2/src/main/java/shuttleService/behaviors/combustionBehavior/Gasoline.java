package shuttleService.behaviors.combustionBehavior;

/**
 * Gasoline Combustion
 */
public class Gasoline implements CombustionBehavior {

    /**
     * Always returns "gasoline"
     * @return string with described behaviour
     */
    @Override
    public String getCombustion() {
        return "gasoline";
    }
}
