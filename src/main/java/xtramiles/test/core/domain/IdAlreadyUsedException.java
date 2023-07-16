package xtramiles.test.core.domain;

public class IdAlreadyUsedException extends DomainException {
    public IdAlreadyUsedException(String message) {
        super(message);
    }
}
