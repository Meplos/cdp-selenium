Feature: Afficher Atelier

    l'utilisateur ajoute des atelier et le systeme lui affiche sous forme d'un liste les différents atelier crée

    Scenario: Aucun atelier
        Given Aucun atelier a été crée
        When je suis dans la page d'accueil
        Then Rien n'est afficher dans la liste

    Scenario: 1 atelier
        Given Un atelier a été crée
        When je suis dans la page d'accueil
        Then un elements comportant un atelier (nom, description) est afficher

    Scenario:  Plusieurs atelier
        Given 2 atelier sont crée
        When je suis sur la page d'accueil
        Then les ateliers sont afficher les un en dessous des autres