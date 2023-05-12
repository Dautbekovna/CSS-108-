public class Time {
    private int hour;
    private int minute;
    private int second;
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public int getHour() {
        return this.hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public int getSecond() {
        return this.second;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public void setSecond(int second) {
        this.second = second;
    }
    public void setTime(int hour, int minute, int second) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }
    public String toString() {
        String hour = this.hour < 10 ? "0" + this.hour : this.hour + "";
        String minute = this.minute < 10 ? "0" + this.minute : this.minute + "";
        String second = this.second < 10 ? "0" + this.second : this.second + "";
        return hour + ":" + minute + ":" + second;
    }
    public Time nextSecond() {
        this.second += 1;
        if (this.second > 59) {
            this.second = 0;
            this.minute += 1;
        }
        if (this.minute > 59) {
            this.minute = 0;
            this.hour += 1;
        }
        if (this.hour > 23) {
            this.hour = 0;
        }
        return this;
    }
    public Time previousSecond() {
        this.second -= 1;
        if (this.second < 0) {
            this.second = 59;
            this.minute -= 1;
        }
        if (this.minute < 0) {
            this.minute = 59;
            this.hour -= 1;
        }
        if (this.hour < 0) {
            this.hour = 23;
        }
        return this;
    }
}
