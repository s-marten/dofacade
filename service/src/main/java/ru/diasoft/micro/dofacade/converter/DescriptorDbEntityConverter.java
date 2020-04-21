package ru.diasoft.micro.dofacade.converter;

import ru.diasoft.micro.dofacade.model.descriptor.Descriptor;
import ru.diasoft.micro.dofacade.model.descriptor.Emotion;
import ru.diasoft.micro.dofacade.model.descriptor.Gender;
import ru.diasoft.micro.dofacade.model.descriptor.Glasses;
import ru.diasoft.micro.dofacade.model.descriptor.HeadPose;
import ru.diasoft.micro.dofacade.model.descriptor.Race;
import ru.diasoft.micro.dofacade.model.entity.DescriptorEntity;

public class DescriptorDbEntityConverter implements Converter<DescriptorEntity, Descriptor> {

    @Override
    public Descriptor createFrom(DescriptorEntity dbItem) {
        Descriptor apiItem = new Descriptor();
        apiItem.setAge(dbItem.getAge());
        apiItem.setGender(getGender(dbItem));
        apiItem.setRace(getRace(dbItem));
        apiItem.setEmotion(getEmotion(dbItem));
        apiItem.setLiveness(dbItem.getLiveness());
        apiItem.setQuality(dbItem.getQuality());
        apiItem.setBeard(dbItem.getBeard());
        apiItem.setGlasses(getGlasses(dbItem));
        apiItem.setHeadPose(getHeadPose(dbItem));
        apiItem.setLuminanceOverexposure(dbItem.getLuminanceOverexposure());
        apiItem.setLuminanceUnderexposure(dbItem.getLuminanceUnderexposure());
        apiItem.setSharpness(dbItem.getSharpness());
        return apiItem;
    }

    private Gender getGender(DescriptorEntity dbItem) {
        Gender gender = new Gender();
        gender.setMale(dbItem.getMale());
        gender.setFemale(dbItem.getFemale());
        return gender;
    }

    private Race getRace(DescriptorEntity dbItem) {
        Race race = new Race();
        race.setAsian(dbItem.getAsian());
        race.setBlack(dbItem.getBlack());
        race.setIndian(dbItem.getIndian());
        race.setWhite(dbItem.getWhite());
        return race;
    }

    private Emotion getEmotion(DescriptorEntity dbItem) {
        Emotion emotion = new Emotion();
        emotion.setAngry(dbItem.getAngry());
        emotion.setDisgust(dbItem.getDisgust());
        emotion.setFear(dbItem.getFear());
        emotion.setHappy(dbItem.getHappy());
        emotion.setSad(dbItem.getSad());
        emotion.setSurprise(dbItem.getSuprpise());
        emotion.setNeutral(dbItem.getNeutral());
        return emotion;
    }

    private Glasses getGlasses(DescriptorEntity dbItem) {
        Glasses glasses = new Glasses();
        glasses.setNoGlasses(dbItem.getNoGlasses());
        glasses.setOpticalGlasses(dbItem.getOpticalGlasses());
        glasses.setSunGlasses(dbItem.getSunGlasses());
        return glasses;
    }

    private HeadPose getHeadPose(DescriptorEntity dbItem) {
        HeadPose headPose = new HeadPose();
        headPose.setYaw(dbItem.getYaw());
        headPose.setPitch(dbItem.getPitch());
        headPose.setRoll(dbItem.getRoll());
        return headPose;
    }
}
