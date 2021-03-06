package ru.diasoft.micro.dqbiometricsid.model.descriptor;

import java.util.Optional;

public class Descriptor {

    private int age;
    private Gender gender;
    private Race race;
    private Emotion emotion;
    private double liveness;
    private double quality;
    private double beard;
    private Glasses glasses;
    private HeadPose headPose;
    private double luminanceOverexposure;
    private double luminanceUnderexposure;
    private double sharpness;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<Gender> getGender() {
        return Optional.ofNullable(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Optional<Race> getRace() {
        return Optional.ofNullable(race);
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Optional<Emotion> getEmotion() {
        return Optional.ofNullable(emotion);
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public double getBeard() {
        return beard;
    }

    public void setBeard(double beard) {
        this.beard = beard;
    }

    public Optional<Glasses> getGlasses() {
        return Optional.ofNullable(glasses);
    }

    public void setGlasses(Glasses glasses) {
        this.glasses = glasses;
    }

    public Optional<HeadPose> getHeadPose() {
        return Optional.ofNullable(headPose);
    }

    public void setHeadPose(HeadPose headPose) {
        this.headPose = headPose;
    }

    public double getLuminanceOverexposure() {
        return luminanceOverexposure;
    }

    public void setLuminanceOverexposure(double luminanceOverexposure) {
        this.luminanceOverexposure = luminanceOverexposure;
    }

    public double getLuminanceUnderexposure() {
        return luminanceUnderexposure;
    }

    public void setLuminanceUnderexposure(double luminanceUnderexposure) {
        this.luminanceUnderexposure = luminanceUnderexposure;
    }

    public double getSharpness() {
        return sharpness;
    }

    public void setSharpness(double sharpness) {
        this.sharpness = sharpness;
    }
}
