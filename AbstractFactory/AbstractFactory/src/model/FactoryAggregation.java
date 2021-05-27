package model;

public class FactoryAggregation implements AbstractFactory {
    @Override
    public ArrowAggregation CreateArrow(double startX, double startY, double endX, double endY) {
        return new ArrowAggregation(startX, startY, endX, endY);
    }
}
