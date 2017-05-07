package co.joebirch.bastion.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.util.TestDataFactory;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StreamTest {

    @Test
    public void buildStage() {
        Stream stream = TestDataFactory.makeStream();

        Stream.Builder streamBuilder = new Stream.Builder()
                .setId(stream.id)
                .setName(stream.name)
                .setUrl(stream.url);

        assertEquals(stream, streamBuilder.build());
    }

}