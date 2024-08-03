package enumeration;
import lombok.Getter;

@Getter
public enum MainPageSectionsName {
    ISSUES (0,"https://habitica.com/"),
    INVENTORY (1, "https://habitica.com/inventory/items"),
    SHOP (2, "https://habitica.com/shops/market"),
    TEAM (3, "https://habitica.com/party"),
    GROUP (4, "https://habitica.com/group-plans"),
    CHALLENGES (5, "https://habitica.com/challenges/myChallenges"),
    FAQ (6, "https://habitica.com/static/faq");
    private final int value;
    private final String link;

    MainPageSectionsName(int value, String link) {
        this.value = value;
        this.link = link;
    }
}
