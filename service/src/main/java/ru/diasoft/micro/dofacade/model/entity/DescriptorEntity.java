package ru.diasoft.micro.dofacade.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "descriptor")
public class DescriptorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "photo_id", nullable = false)
    private Long photoId;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender_male", nullable = false)
    private Double male;

    @Column(name = "gender_female", nullable = false)
    private Double female;

    @Column(name = "race_asian", nullable = false)
    private Double asian;

    @Column(name = "race_black", nullable = false)
    private Double black;

    @Column(name = "race_indian", nullable = false)
    private Double indian;

    @Column(name = "race_white", nullable = false)
    private Double white;

    @Column(name = "emotion_angry", nullable = false)
    private Double angry;

    @Column(name = "emotion_disgust", nullable = false)
    private Double disgust;

    @Column(name = "emotion_fear", nullable = false)
    private Double fear;

    @Column(name = "emotion_happy", nullable = false)
    private Double happy;

    @Column(name = "emotion_sad", nullable = false)
    private Double sad;

    @Column(name = "emotion_suprpise", nullable = false)
    private Double suprpise;

    @Column(name = "emotion_neutral", nullable = false)
    private Double neutral;

    @Column(name = "liveness", nullable = false)
    private Double liveness;

    @Column(name = "quality", nullable = false)
    private Double quality;

    @Column(name = "beard", nullable = false)
    private Double beard;

    @Column(name = "no_glasses", nullable = false)
    private Double noGlasses;

    @Column(name = "optical_glasses", nullable = false)
    private Double opticalGlasses;

    @Column(name = "sun_glasses", nullable = false)
    private Double sunGlasses;

    @Column(name = "head_pose_yaw", nullable = false)
    private Integer yaw;

    @Column(name = "head_pose_pitch", nullable = false)
    private Integer pitch;

    @Column(name = "head_pose_roll", nullable = false)
    private Integer roll;

    @Column(name = "luminance_overexposure", nullable = false)
    private Double luminanceOverexposure;

    @Column(name = "luminance_underexposure", nullable = false)
    private Double luminanceUnderexposure;

    @Column(name = "sharpness", nullable = false)
    private Double sharpness;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMale() {
        return male;
    }

    public void setMale(Double male) {
        this.male = male;
    }

    public Double getFemale() {
        return female;
    }

    public void setFemale(Double female) {
        this.female = female;
    }

    public Double getAsian() {
        return asian;
    }

    public void setAsian(Double asian) {
        this.asian = asian;
    }

    public Double getBlack() {
        return black;
    }

    public void setBlack(Double black) {
        this.black = black;
    }

    public Double getIndian() {
        return indian;
    }

    public void setIndian(Double indian) {
        this.indian = indian;
    }

    public Double getWhite() {
        return white;
    }

    public void setWhite(Double white) {
        this.white = white;
    }

    public Double getAngry() {
        return angry;
    }

    public void setAngry(Double angry) {
        this.angry = angry;
    }

    public Double getDisgust() {
        return disgust;
    }

    public void setDisgust(Double disgust) {
        this.disgust = disgust;
    }

    public Double getFear() {
        return fear;
    }

    public void setFear(Double fear) {
        this.fear = fear;
    }

    public Double getHappy() {
        return happy;
    }

    public void setHappy(Double happy) {
        this.happy = happy;
    }

    public Double getSad() {
        return sad;
    }

    public void setSad(Double sad) {
        this.sad = sad;
    }

    public Double getSuprpise() {
        return suprpise;
    }

    public void setSuprpise(Double suprpise) {
        this.suprpise = suprpise;
    }

    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

    public Double getLiveness() {
        return liveness;
    }

    public void setLiveness(Double liveness) {
        this.liveness = liveness;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public Double getBeard() {
        return beard;
    }

    public void setBeard(Double beard) {
        this.beard = beard;
    }

    public Double getNoGlasses() {
        return noGlasses;
    }

    public void setNoGlasses(Double noGlasses) {
        this.noGlasses = noGlasses;
    }

    public Double getOpticalGlasses() {
        return opticalGlasses;
    }

    public void setOpticalGlasses(Double opticalGlasses) {
        this.opticalGlasses = opticalGlasses;
    }

    public Double getSunGlasses() {
        return sunGlasses;
    }

    public void setSunGlasses(Double sunGlasses) {
        this.sunGlasses = sunGlasses;
    }

    public Integer getYaw() {
        return yaw;
    }

    public void setYaw(Integer yaw) {
        this.yaw = yaw;
    }

    public Integer getPitch() {
        return pitch;
    }

    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public Double getLuminanceOverexposure() {
        return luminanceOverexposure;
    }

    public void setLuminanceOverexposure(Double luminanceOverexposure) {
        this.luminanceOverexposure = luminanceOverexposure;
    }

    public Double getLuminanceUnderexposure() {
        return luminanceUnderexposure;
    }

    public void setLuminanceUnderexposure(Double luminanceUnderexposure) {
        this.luminanceUnderexposure = luminanceUnderexposure;
    }

    public Double getSharpness() {
        return sharpness;
    }

    public void setSharpness(Double sharpness) {
        this.sharpness = sharpness;
    }
}
