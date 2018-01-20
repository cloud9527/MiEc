package com.example.cloud.mi_core.delegates.web.event;

import android.support.annotation.NonNull;

import java.util.HashMap;

/**
 * Created by cloud on 2018/1/20.
 */

public class EventManager {
    private final static HashMap<String, Event> EVENTS = new HashMap<>();

    private EventManager() {
    }

    private static class Holder {
        private static final EventManager INSTANCE = new EventManager();
    }

    public static EventManager getInstance() {
        return Holder.INSTANCE;
    }

    public EventManager addEvent(@NonNull String name, @NonNull Event event) {
        EVENTS.put(name, event);
        return this;
    }

    public Event createEvent(String action) {
        final Event event = EVENTS.get(action);
        if (event == null) {
            return new UndefineEvent();
        }
        return event;
    }

}
