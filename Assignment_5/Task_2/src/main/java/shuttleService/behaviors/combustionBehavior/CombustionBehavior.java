package shuttleService.behaviors.combustionBehavior;

/**
 * Combustion behaviour interface, defines weather a car runs on Diesel, Electric or Gasoline
 */
public interface CombustionBehavior {

    /**
     * Get the combustion behaviour as string
     * @return string with described behaviour
     */
    public String getCombustion();

}
