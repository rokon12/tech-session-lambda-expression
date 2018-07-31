package com.bazlur.example;

public class Disk {
    public enum Type {
        SATA, PATA, SCSI, SAS, FC
    }

    private int size;
    private int speed;
    private Type type;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Disk() {
    }

    public Disk(int size, int speed, Type type) {
        this.size = size;
        this.speed = speed;
        this.type = type;
    }

    public static DiskBuilder disk() {
        return size -> speed -> type -> new Disk(size, speed, type);
    }

    public interface DiskBuilder {
        SpeedBuilder size(int size);
    }

    public interface SpeedBuilder {
        TypeBuilder speed(int speed);
    }

    public interface TypeBuilder {
        Disk type(Type type);

        default Disk sata() {
            return type(Type.SATA);
        }
    }
}