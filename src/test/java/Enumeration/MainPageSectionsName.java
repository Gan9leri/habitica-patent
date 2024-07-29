package Enumeration;

import lombok.Getter;

@Getter
public enum MainPageSectionsName {

    ISSUES ("Задачи","https://habitica.com/"),
    INVENTORY ("Инвентарь", "https://habitica.com/inventory/items"),
    SHOP ("Лавки", "https://habitica.com/shops/market"),
    TEAM ("Команда", "https://habitica.com/party"),
    GROUP ("Группа", "https://habitica.com/group-plans"),
    CHALLENGES ("Испытания", "https://habitica.com/challenges/myChallenges"),
    FAQ ("Помощь", "https://habitica.com/static/faq");


    private final String value;
    private final String link;

    MainPageSectionsName(String value, String link) {
        this.value = value;
        this.link = link;
    }



}
