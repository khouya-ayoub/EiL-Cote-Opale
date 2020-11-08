package code;

import annotations.MonAnnotation;
import annotations.NotNull;

@MonAnnotation(nom = "KHOUYA", prenom = "Ayoub", niveau = MonAnnotation.Niveau.CONFIRME, isNull = true)
public class MaSubClasse {

    public void testNotNull() {
        @NotNull
        MaClasse maClasse;
    }

}