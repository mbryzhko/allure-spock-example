package ru.yandex.qatools.allure

import ru.yandex.qatools.allure.annotations.Features
import ru.yandex.qatools.allure.annotations.Stories
import ru.yandex.qatools.allure.model.Label
import spock.lang.Specification
import spock.lang.Unroll

class ServiceSpec extends Specification {

	Service service

	def setup() {
		service = new Service()
	}

	@Features("My Feature")
	@Stories(["Story1", "Story2"])
	def "adding integers works"() {
		expect:
			service.plus(1, 3) == 4
	}

	@Features("My Feature")
	@Unroll
	def "parametrized test. #a plus #b equals #result"(def a, def b, def result) {
		when:
			def actual = service.plus(a, b)
		then:
			actual == result
		where:
			a	| b		|| result
			1	| 2		|| 3
			"a"	| "b"	|| "ab"
			"1"	| 3		|| 4

	}

}
