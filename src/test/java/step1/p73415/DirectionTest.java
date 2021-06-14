package step1.p73415;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @Test
    @DisplayName("로봇이 움직이면 맞는 방향으로 가는지 테스트")
    void directionTest() {
        Point currentPoint = new Point(1, 0);

        Point movedPoint = Direction.D.Calculator(currentPoint);
        assertThat(movedPoint.equals(new Point(1, -1))).isTrue();

        movedPoint = Direction.U.Calculator(currentPoint);
        assertThat(movedPoint.equals(new Point(1, 1))).isTrue();

        movedPoint = Direction.L.Calculator(currentPoint);
        assertThat(movedPoint.equals(new Point(0, 0))).isTrue();

        movedPoint = Direction.R.Calculator(currentPoint);
        assertThat(movedPoint.equals(new Point(2, 0))).isTrue();
    }
}
