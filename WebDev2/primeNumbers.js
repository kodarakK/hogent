'use strict';

for (let i = 0; i <= 100; i++) {
	for (let number = 2; number < i; number++) {
		let isPrime = true;
		for (let dividend = 2; dividend <= number / 2; dividend++) {
			if (number % dividend === 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) console.log(number + ' is prime');
	}
}

