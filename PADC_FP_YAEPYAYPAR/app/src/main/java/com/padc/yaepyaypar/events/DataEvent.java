package com.padc.yaepyaypar.events;

/**
 * Created by mkt on 9/17/2016.
 */
public class DataEvent {

    public static class DatePickedEvent {
        private String dateOfBrith;

        public DatePickedEvent(String dateOfBrith) {
            this.dateOfBrith = dateOfBrith;
        }

        public String getDateOfBrith() {
            return dateOfBrith;
        }
    }

}
