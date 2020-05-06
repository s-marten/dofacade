package ru.diasoft.micro.dqbiometricsid.converter;

import ru.diasoft.micro.dqbiometricsid.model.descriptor.Descriptor;
import ru.diasoft.micro.dqbiometricsid.model.entity.DescriptorEntity;

public class DescriptorToDbEntityConverter implements Converter<Descriptor, DescriptorEntity> {

    @Override
    public DescriptorEntity createFrom(Descriptor descriptor) {
        DescriptorEntity entity = new DescriptorEntity();
        entity.setAge(descriptor.getAge());
        descriptor.getGender().ifPresent(it -> {
            entity.setMale(it.getMale());
            entity.setFemale(it.getFemale());
        });
        descriptor.getRace().ifPresent(it -> {
            entity.setAsian(it.getAsian());
            entity.setBlack(it.getBlack());
            entity.setIndian(it.getIndian());
            entity.setWhite(it.getWhite());
        });
        descriptor.getEmotion().ifPresent(it -> {
            entity.setAngry(it.getAngry());
            entity.setDisgust(it.getDisgust());
            entity.setFear(it.getFear());
            entity.setHappy(it.getHappy());
            entity.setSad(it.getSad());
            entity.setSuprpise(it.getSurprise());
            entity.setNeutral(it.getNeutral());
        });
        entity.setLiveness(descriptor.getLiveness());
        entity.setQuality(descriptor.getQuality());
        entity.setBeard(descriptor.getBeard());
        descriptor.getGlasses().ifPresent(it -> {
            entity.setNoGlasses(it.getNoGlasses());
            entity.setOpticalGlasses(it.getOpticalGlasses());
            entity.setSunGlasses(it.getSunGlasses());
        });
        descriptor.getHeadPose().ifPresent(it -> {
            entity.setYaw(it.getYaw());
            entity.setPitch(it.getPitch());
            entity.setRoll(it.getRoll());
        });
        entity.setLuminanceOverexposure(descriptor.getLuminanceOverexposure());
        entity.setLuminanceUnderexposure(descriptor.getLuminanceUnderexposure());
        entity.setSharpness(descriptor.getSharpness());

        return entity;
    }
}
