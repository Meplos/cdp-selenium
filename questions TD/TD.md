# TD

## Q1 

    modifier_atelier.feature

## Q2
SETUP setup_background()
- login(user)
- load_page(uri)

OUTILS
- get_html(uri)
- get_html(id_element)
- html_to_list(id_element)
- get_value(id_element_textarea)

EVENEMENT
- on_click(id_element_html)
- key_in(text)

RESULTAT
- lists_equals(l1, l2)
- exists(id_container_html, id_element_html)
- is_modifiable(id_element_textarea)

## Q3
    setup_background(){
        login(inria)
        load_page("/index")
    }

    see_workshop_list(){
        on_click("#button_my_workshop")
        list_html = html_to_list("#workshop_lists")
        list_db = workshop_list_from_db(inria)
        for (item in list_html){
            assert exists(item, #modify_button)
        }
        assert lists_equals(list_html, list_db)
    }

    from_workshop_list(workshop_fields){
        load_page("/my_workshops")
        on_click("li #1 #modify_button")
        modify_page_ok(workshop_fields)
    }

    see_workshop_page_button(workshop, workshop_fields){
        load_page(workshop)
        assert exists("body", "#modify_button")
    }

    from_workshop_page(workshop, workshop_fields){
        load_page(workshop)
        on_click("#modify_button")
        modify_page_ok(workshop_fields)
    }

    modify_page_ok(workshop_fields){
        assert exists("body", "#form_modify_workshop")
        form = html_to_list("#form_modify_workshop")
        lists_equals(form, workshop_fields)
        for (field in form){
            assert (get_value(field) != "")
            assert is_modifiable(field)
        }
    }

    changes_saved(){
        load_page(workshop + "/modify")
        on_click("#textarea_theme")
        key_in("Nouveau thème")
        on_click("#textarea_description")
        key_in("Nouvelle description")
        on_click("#save_button")
        assert ("Nouveau thème" = get_value("#theme_value))
        assert ("Nouvelle description" = get_value("#description_value"))
    }

    workshop_not_mine(workshop_cnrs){
        load_page(workshop_cnrs)
        assert (get_html("#modify_button") = null)
    }

## Q4

Il faudra que l'architecture utilisée simule les actions spécifiées sur un navigateur web. 

Couplé avec un outil comme git, il faudrait qu'à chaque commit, tous les tests soient lancées sur la version modifiée. Les résultats des tests devront être stockés afin que l'on puisse garder un trace. 

On pourrait même imaginer qu'un commit qui casserait des résultats d'un test qui passait dans la version précédente du code ne serait pas admis dans le dépôt global.