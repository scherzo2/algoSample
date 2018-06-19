/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package my.simple;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import my.simple.service.Rect;
import my.simple.service.SquareUtil;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link SquareUtil}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleSimpleApplication.class)
public class SquareUtilTest {

    @Inject
    SquareUtil util;

	@Test
	public void calcInterSection1() {
	    float result = util.calcInterSection(new Rect(0, 10, 0, 8), new Rect(3, 13, 5, 12));
	    assertEquals(21f, result, 0f);
        result = util.calcInterSection(new Rect(0, 10, 0, 8), new Rect(-1, 13, 5, 12));
        assertEquals(30f, result, 0f);
        result = util.calcInterSection(new Rect(0, 10, 0, 8), new Rect(9, 13, 5, 12));
        assertEquals(3f, result, 0f);
        result = util.calcInterSection(new Rect(0, 10, 0, 8), new Rect(1, 9, 5, 12));
        assertEquals(24f, result, 0f);
        result = util.calcInterSection(new Rect(0, 10, 0, 8), new Rect(11, 12, 5, 12));
        assertEquals(0f, result, 0f);
        result = util.calcInterSection(new Rect(0, 10, 0, 8), new Rect(3, 13, -1, 3));
        assertEquals(21f, result, 0f);
        result = util.calcInterSection(new Rect(0, 10, 0, 8), new Rect(3, 13, 1, 7));
        assertEquals(42f, result, 0f);
        result = util.calcInterSection(new Rect(0, 10, 0, 8), new Rect(3, 13, -1, 9));
        assertEquals(56f, result, 0f);
	}
}
