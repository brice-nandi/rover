package com.exercise.model;

public class Rover {

    private Position position;
    private Orientation orientation;

    Rover(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return position + " " + orientation;
    }

    public static class RoverBuilder{

        private Position position;
        private Orientation orientation;

        public RoverBuilder setPosition(Position position) {
            this.position = position;
            return this;
        }

        public RoverBuilder setOrientation(Orientation orientation) {
            this.orientation = orientation;
            return this;
        }

        public Rover build() {
            return new Rover(this.position, this.orientation);
        }
    }
}
