Feature: Creation d'atelier

    L'utilisateur va cliquer sur le bouton "Create new workshop" et etre redirigé sur le formulaire. Il va entrer un "nom" et une "description".
    Puis va cliquer sur "save" et sera redirigé sur la page d'accueil avec l'atelier ajouté a la liste d'ateliers.

    Scenario: Acceder au formulaire
        Given la page d'accueil "/workshop" est affichée 
        When j'appuis sur le bouton "Create new workshop"
        Then le formulaire de création s'affiche

    Scenario: Ajout d'un atelier
        Given le formulaire est affiché
        And l'utilisateur remplit les champs "nom" et "description"
        When l'utilisateur clique sur le bouton "Save"
        Then l'utilisateur est redirigé sur la page d'accueil et son atelier est ajouté à la liste et est affiché

    Scenario: Ajout d'un atelier sans description
        Given le formulaire est affiché
        And l'utilisateur remplit le champ "nom"
        When l'utilisateur clique sur le bouton "Save"
        Then un toast s'affiche sous le champs "description" est indique :"Veuillez renseigner ce champs"

    Scenario: Ajout d'un atelier sans nom 
        Given le formulaire est affiché
        And l'utilisateur remplit le champ "description"
        When l'utilisateur clique sur le bouton "Save"
        Then un toast s'affiche sous le champs "nom" est indique :"Veuillez renseigner ce champs"

    Scenario: Non ajout d'un atelier
        Given le formulaire est affiché
        And l'utilisateur remplit les champs "nom" et "description"
        When l'utilisateur clique sur le bouton "Cancel"
        Then l'utilisateur est redirigé sur la page d'accueil et aucune modification n'est faite

     
        


