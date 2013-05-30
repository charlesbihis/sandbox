<?
$quotes = array("Who needs a safe when you can do THIS?!",
				"I ain't no hipster, but I can make your hips stir",
				"Hhhhheeeeeyyyyy FUCK ME EVERYBODY, I LOVE RICHARD CLOONEY!",
				"What, you expect me to go in the bathroom like a psycho?!",
				"CHEEMMISSTRYYYY",
				"BANGARANG!",
				"I love party girls",
				"Mahal kitaaaaay! -Spencer Hamade",
				"Yo yo yo, Jenny's a thirsty girl, y'know what I'm sayin'?",
				"All...the...ladies leave your man at home, the club is full of ballers and they pockets full grown...nnn...nnnnn...nnnn...AND THE CLUB IS JUMPIN JUMPIN!");

#constuct the random quote selector
$n = count($quotes);
$num = rand(0, ($n - 1));
$quote = $quotes[$num];
$text = $quote;

print "$text";
?>