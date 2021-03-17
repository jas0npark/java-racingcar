package study.step4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNERS = "가 최종 우승했습니다.";
    private static final String NEW_LINE = "\n";
    private static final String DASH = "-";
    private static final String DELIMITER = "";

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    public static void printRace(Cars cars) {
        System.out.println(
                cars.stream()
                        .map(car ->
                                car.getCarName() + RacingConstant.NAME_SPACE + carLocationToString(car.getLocation())
                        )
                        .collect(Collectors.joining(NEW_LINE))
                        + NEW_LINE
        );
    }

    public static void printRaceWinner(List<Car> cars) {
        String winners = cars.stream().map(car -> car.getCarName())
                .collect(Collectors.joining(RacingConstant.COMMA));

        System.out.println(winners + FINAL_WINNERS);
    }

    private static String carLocationToString(int location) {
        return Arrays.stream(new int[location])
                .mapToObj(i -> DASH)
                .collect(Collectors.joining(DELIMITER));
    }
}