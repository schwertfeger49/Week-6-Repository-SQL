import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class TestDemoTest {
	
	private TestDemo testDemo;

	@Test
	void assertThatNumberSquaredIsCorrect () {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
	}
	
	static Stream<Arguments> getPositiveNumbersToAdd(){
		return(Stream.of(
				arguments(4, 9, 13, false),
				arguments(0, 9, 9, true),
				arguments(-1, 9, 8, true),
				arguments(-3, 0, -3, true),
				arguments(-4, -9, -13, true)
				));
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#getPositiveNumbersToAdd")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

}
