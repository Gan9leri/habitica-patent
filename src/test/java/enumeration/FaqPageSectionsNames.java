package enumeration;

import lombok.Getter;

@Getter
public enum FaqPageSectionsNames {
    HOW_IT_WORKS(0, "https://habitica.com/static/features"),
    GROUP_PLANS(1, "https://habitica.com/static/plans"),
    FOR_PRESS(4, "https://habitica.com/static/press-kit"),
    CONTACT(5, "https://habitica.com/static/contact");
    private final int value;
    private final String link;

    FaqPageSectionsNames(int value, String link) {
        this.value = value;
        this.link = link;
    }
}
