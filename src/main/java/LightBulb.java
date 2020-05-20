public class LightBulb  {
    private Integer brightness;

    protected LightBulb(Integer brightness)
    {
        this.brightness = brightness;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return brightness + " лк ";
    }
}
