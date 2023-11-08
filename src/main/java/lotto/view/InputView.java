package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validation.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int promptPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구매 금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine().trim());
                InputValidation.validatePurchaseAmount(purchaseAmount);
                InputValidation.validatePurchaseThousand(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR]숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto promptWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> numbers = Arrays.stream(input)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}

