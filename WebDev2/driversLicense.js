'use strict';

const speedLimiet = 70;
const kmPerPoint = 5;
let message = '';

const speed = 82;

if (isNaN(speed)) message = 'not a number';
else if (speed <= speedLimiet) message = 'OK';
else {
	const points = Math.floor((speed - speedLimiet) / kmPerPoint);

	if (points > 12) message = `points: ${points}`
	else message = 'drivers license suspended';

}
console.log(message);
