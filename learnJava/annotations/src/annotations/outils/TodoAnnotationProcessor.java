package annotations.outils;

import annotations.Todo;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes(value = {"annotations.Todo"})

public class TodoAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // Parcourrir tout les annotations
        for (TypeElement te : annotations) {
            System.out.println("Traitement annotation : " + te.getQualifiedName());
            // Récupérer tous les élèments annotés avec l'annotations en cours
            for (Element element : roundEnv.getElementsAnnotatedWith(te)) {
                String name = element.getClass().toString();
                System.out.println("------------------------------");
                // Savoir quel type de l'élèment annoté
                System.out.println("Type d'élèment annoté : " + element.getKind());
                // Retourne le nome de lélèment annoté
                System.out.println("Nom de l'élèment : " + element.getSimpleName());
                // Récupérer notre annotation
                Todo todo = element.getAnnotation(Todo.class);
                // s'il n'est pa null
                if (todo != null) {
                    System.out.println("Importanec : " + todo.importance());
                    System.out.println("assigne : " + todo.assigneA() );
                }
            }
        }




        return false;
    }
}
