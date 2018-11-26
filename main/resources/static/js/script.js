let questTime = document.getElementsByClassName('questTime');

for (let i = 0; i < questTime.length; i++) {
    let value = Number(questTime[i].textContent);
    let date = new Date().getTime();
    let x = Math.round((value - date)/1000);
    questTime[i].textContent = x;

    const interval = setInterval(timeLeft, 1000);

    function timeLeft(){
        questTime[i].textContent = --x;

        if (x === 0) {
           clearInterval(interval);
           location.href = "/check";
        }
    }
}

