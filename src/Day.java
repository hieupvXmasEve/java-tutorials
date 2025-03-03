public enum Day {

    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
    private int dayNumber;

    Day(int day) {
        this.dayNumber = day;
    }

    /**
     * @return the day of the week as a number, where Sunday is 1 and Saturday is 7.
     */
    public int getDayNumber() {
        return dayNumber;
    }
}
