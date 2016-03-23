package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;

public interface Validators {
    public boolean isValid(Balls balls, Ball ball) throws Exception;
}
