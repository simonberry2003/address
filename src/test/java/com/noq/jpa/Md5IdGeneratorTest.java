package com.noq.jpa;

import org.hibernate.engine.spi.SessionImplementor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import lombok.val;

public class Md5IdGeneratorTest {

	@Test
	public void test() {
		val session = Mockito.mock(SessionImplementor.class);
		val object = Mockito.mock(Hashable.class);
		Mockito.when(object.getHashString()).thenReturn("hash");
		val generator = new Md5IdGenerator();
		Assert.assertEquals("0800fc577294c34e0b28ad2839435945", generator.generate(session, object));
	}
}
