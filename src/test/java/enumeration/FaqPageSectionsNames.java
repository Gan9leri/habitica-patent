package enumeration;
import lombok.Getter;

@Getter
public enum FaqPageSectionsNames {
    HOW_IT_WORKS ("Как это работает", "https://habitica.com/static/features"),
    GROUP_PLANS ("Групповые планы", "https://habitica.com/static/plans"),
    FOR_PRESS("Для прессы", "https://habitica.com/static/press-kit"),
    CONTACT ("Обратная связь", "https://habitica.com/static/contact");
    private final String value;
    private final String link;

    FaqPageSectionsNames(String value, String link) {
        this.value = value;
        this.link = link;
    }
}
