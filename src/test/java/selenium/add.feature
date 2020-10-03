Feature: Creation d'atelier

    L'utilisateur va cliquer sur le bouton "Create new workshop" et etre rediriger sur le formulaire. Il va entré un "nom" et une "description".
    Puis va cliquer sur "save" et sera rediriger sur la page d'accueil avec l'atelier ajouter a la liste d'atelier.

    Scenario: Acceder au formulaire
        Given la page d'accueil "/workshop" est afficher 
        When j'appuis sur le bouton "Create new workshop"
        Then le formulaire de création s'affiche

    Scenario: Ajout d'un atelier
        Given le formulaire est affiché
        And l'utilisateur remplis les champs "nom" et "description"
        When l'utilisateur clique sur le bouton "Save"
        Then l'utilisateur est rediriger sur la page d'accueil et son atelier est ajouter à la liste et est afficher

    Scenario: Ajout d'un atelier sans description
        Given le formulaire est affiché
        And l'utilisateur remplis les champs "nom"
        When l'utilisateur clique sur le bouton "Save"
        Then un toast s'affiche sous le champs "desciption" est indique :"Veuillez renseigné ce champs"

    Scenario: Ajout d'un atelier sans nom 
        Given le formulaire est affiché
        And l'utilisateur remplis les champs "description"
        When l'utilisateur clique sur le bouton "Save"
        Then un toast s'affiche sous le champs "nom" est indique :"Veuillez renseigné ce champs"

    Scenario: Non ajout d'un atelier
        Given le formulaire est affiché
        And l'utilisateur remplis les champs "nom" et "description"
        When l'utilisateur clique sur le bouton "Cancel"
        Then l'utilisateur est rediriger sur la page d'accueil et aucune modification n'est fait

     
        


