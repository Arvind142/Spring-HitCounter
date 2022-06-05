package com.personal.hitcounter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class HitCounterApplicationTests {

	@Test
	void contextLoads() {
		// no assertion
		int a = 1;
		Assertions.assertEquals(1,a);
	}

}
