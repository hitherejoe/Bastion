package co.joebirch.bastion.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.util.TestDataFactory;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StageTest {

    @Test
    public void buildStage() {
        Stage stage = TestDataFactory.makeStage();

        Stage.Builder stageBuilder = new Stage.Builder()
                .setName(stage.name)
                .setNumber(stage.number)
                .setSize(stage.size)
                .setType(stage.type);

        assertEquals(stage, stageBuilder.build());
    }

}