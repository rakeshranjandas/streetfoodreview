package project.streetfoodreview.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Rating {
    ZERO(0),ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
    private final int code;
}
