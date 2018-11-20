
var questTime = parseInt(document.querySelector(".questTime").textContent);
console.log(questTime);
setInterval(function(){
    let x = questTime--;
    questTime.textContent = x.toString;
console.log(questTime);
}, 1000);