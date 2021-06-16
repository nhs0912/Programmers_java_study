package step1.p73415;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RobotTest {

    Stage stage = new Stage();

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("차가 움직이는 지 테스트 ")
    void moveTest() {
        Robot robot = new Robot(stage);

        assertAll(
                () -> {
                    robot.move(Direction.D);
                    assertThat(robot.point().equals(new Point(0, -1))).isTrue();
                },

                () -> {
                    robot.move(Direction.U);
                    assertThat(robot.point().equals(new Point(0, 0))).isTrue();
                },

                () -> {
                    robot.move(Direction.L);
                    assertThat(robot.point().equals(new Point(-1, 0))).isTrue();
                },

                () -> {
                    robot.move(Direction.R);
                    assertThat(robot.point().equals(new Point(0, 0))).isTrue();
                },

                () -> {
                    Robot robot2 = new Robot(stage, new Point(5, 0));
                    robot2.move(Direction.R);
                    assertThat(robot2.point().equals(new Point(5, 0))).isTrue();
                }

        );


    }

    @Test
    @DisplayName("차가 몇번 움직였는지 테스트 ")
    void moveCountTest() {
        //LULLLLLLU
        String dirs = "LULLLLLLU";
        int result = new Solution().solution(dirs);

        assertThat(result).isEqualTo(7);
    }


}
