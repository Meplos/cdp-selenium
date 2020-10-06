Feature: Afficher Atelier

    l'utilisateur ajoute des ateliers et le systeme lui affiche sous forme d'un liste les différents ateliers créés

    Scenario: Aucun atelier
        Given Aucun atelier n'a été créé
        When je suis dans la page d'accueil
        Then Rien n'est affiché dans la liste

    Scenario: 1 atelier
        Given Un atelier a été créé
        When je suis dans la page d'accueil
        Then un éléments comportant un atelier (nom, description) est affiché

    Scenario:  Plusieurs atelier
        Given 2 ateliers sont créés
        When je suis sur la page d'accueil
        Then les ateliers sont affichés les un en dessous des autres