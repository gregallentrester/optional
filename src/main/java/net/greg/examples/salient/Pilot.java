package net.greg.examples.salient;


public final class Pilot {

  public static void main(String ... a) {

    new Pilot().
      averOptional(Boolean.FALSE).
      averOptional(new Pilot.DroneMessage()).
      averOptional(new Pilot.FalseMessage()).
      averOptional(new Pilot.TrueMessage()).
      averOptional(new Pilot.DroneMessage());

    System.err.println(
      YLW + "\n\t...  ...  ..." + NC + "\n\n");
  }


  private final Pilot averOptional(Object any) {

    System.err.println(
      "\n\n\tType | " + any.getClass());

    try {

      if ( ! any.toString().equals(null)) {

        System.err.println(
          GRN + "\t   MSG: " + any.toString() + NC);
      }
    }
    catch (Throwable e) {

      System.err.println(
        RED + "\t   Cause: " + e.getCause() + NC +
        GRN + "\n\t   Localized Message: " + e.getLocalizedMessage() + NC);
    }

    return this;
  }


  public static final class TrueMessage {
    @Override
    public String toString() {
      return Boolean.TRUE.
        toString().toUpperCase();
    }
  }

  public static final class FalseMessage {
    @Override
    public String toString() {
      return Boolean.FALSE.
        toString().toUpperCase();
    }
  }

  public static final class DroneMessage {

    @Override
    public String toString() {
      return null;
    }
  }

  private static final String RED = "\033[1;91m";
  private static final String GRN = "\033[1;92m";
  private static final String YLW = "\033[1;93m";
  private static final String NC = "\u001B[0m";
}
