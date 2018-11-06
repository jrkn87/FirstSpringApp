var btn = document.querySelector('button');
var p = document.querySelector('p');

let rand = 0;

btn.addEventListener('click', function(){
	rand = Math.floor(Math.random()*100);
	p.textContent = rand;
});
