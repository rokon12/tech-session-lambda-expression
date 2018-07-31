package com.bazlur.example;

public class Processor {
    public enum Type {
        i386, x64, x86_64
    }

    private final int cores;
    private final int speed;
    private final Type type;

    public int getCores() {
        return cores;
    }

    public int getSpeed() {
        return speed;
    }

    public Type getType() {
        return type;
    }

    public Processor(int cores, int speed, Type type) {
        this.cores = cores;
        this.speed = speed;
        this.type = type;
    }

    public static ProcessorBuilder processor() {
        return core -> speed -> type -> new Processor(core, speed, type);
    }

    public interface ProcessorBuilder {
        SpeedBuilder core(int core);
    }

    public interface SpeedBuilder {
        TypeBuilder speed(int speed);
    }

    public interface TypeBuilder {
        Processor type(Type type);

        default Processor i386() {
            return type(Type.i386);
        }
    }

    public static void main(String[] args) {

        Processor.processor()
                .core(2)
                .speed(3)
                .i386();
    }
}
