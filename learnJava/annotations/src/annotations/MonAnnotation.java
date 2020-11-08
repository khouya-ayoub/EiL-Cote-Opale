package annotations;

public @interface MonAnnotation {
    enum Niveau {DEBUTATNT, CONFIRME, EXPERT};
    String nom() default "";
    String prenom();
    Niveau niveau() default Niveau.DEBUTATNT;
    boolean isNull() default false;
}
