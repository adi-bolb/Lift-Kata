package codingdojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lift {
    private String id;
    private int floor;
    private HashSet<Integer> requests;
    private boolean doorsOpen;

    public Lift(String id, int floor, List<Integer> requests, boolean doorsOpen) {

        this.id = id;
        this.floor = floor;
        this.requests = new HashSet<>(requests);
        this.doorsOpen = doorsOpen;
    }

    public Lift(String id, int floor) {
        this(id, floor, new ArrayList<Integer>(), false);
    }

    public Lift(String id, int floor, List<Integer> requests) {
        this(id, floor, requests, false);
    }

    public Lift(String id, int floor, boolean doorsOpen) {
        this(id, floor, new ArrayList<Integer>(), doorsOpen);
    }

    public String getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public boolean hasRequestForFloor(int floor) {
        return this.requests.contains(floor);
    }

    public boolean areDoorsOpen() {
        return doorsOpen;
    }

    public void tick() {
        if(requests.contains(this.floor)) {
            this.doorsOpen = true;
            this.requests.remove(this.floor);
        }
        else if (!requests.isEmpty()) {
            for (int request:requests) {
                this.floor = request;
                break;
            }
        }
    }
}
