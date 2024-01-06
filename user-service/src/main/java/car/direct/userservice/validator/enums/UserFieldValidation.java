package car.direct.userservice.validator.enums;

import org.apache.logging.log4j.util.TriConsumer;
import car.direct.userservice.dto.request.UserRequestDto;
import car.direct.userservice.validator.UserValidator;

import java.util.List;

public enum UserFieldValidation {
    EMAIL(UserValidator::validateEmail);
//    NAME(UserValidator::validateFullName),
    private final TriConsumer<UserValidator, UserRequestDto, List<String>> consumer;

    UserFieldValidation(TriConsumer<UserValidator, UserRequestDto, List<String>> consumer) {
        this.consumer = consumer;
    }

    public void consume(UserValidator validator, UserRequestDto requestDto, List<String> messages) {
        consumer.accept(validator, requestDto, messages);
    }
}