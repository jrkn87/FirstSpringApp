var canvas = document.querySelector('canvas');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;
var ctx = canvas.getContext('2d');

let mouse = {
    x: undefined,
    y: undefined
}

let maxRadius = 80;

let colorArr = [
    '#036169',
    '#045659',
    '#588C8F',
    '#96BEC0',
    '#EDF4F5'
];

window.addEventListener('mousemove', function(event) {
    mouse.x = event.x;
    mouse.y = event.y;
})

window.addEventListener('resize', function() {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    
    init();
})

function Circle(x, y, dx, dy, radius) {
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;
    this.radius = radius;
    this.minRadius = radius;
    this.color = colorArr[Math.floor(Math.random() * colorArr.length)];

    this.draw = function() {
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2, false);
        ctx.fillStyle = this.color;
        ctx.fill();
    }
    
    this.update = function() {
        if (this.x + this.radius > innerWidth || this.x - this.radius < 0) {
            this.dx = -this.dx;
        }
        if (this.y + this.radius > innerHeight || this.y - this.radius < 0) {
            this.dy = -this.dy;
        }

        this.x += this.dx;
        this.y += this.dy;
        
        //mouse interactivity
        if (mouse.x - this.x < 50 
                && mouse.x - this.x > -50
                && mouse.y - this.y < 50
                && mouse.y - this.y > -50) {
            if (this.radius < maxRadius)
                this.radius += 1;
        } else if (this.radius > this.minRadius) {
            this.radius -= 1;
        }
        
        this.draw();
    }
}

let circleArr = [];

function init() {
    circleArr = [];
    for (let i = 0; i < 1000; i++) {
        let radius = Math.random() * 3 + 1;
        let x = Math.random() * (innerWidth - radius * 2) + radius;
        let y = Math.random() * (innerHeight - radius * 2) + radius;
        let dx = (Math.random() -0.5);
        let dy = (Math.random() -0.5);

        circleArr.push(new Circle(x, y, dx, dy, radius));
    }
}

function animate() {
    requestAnimationFrame(animate);
    ctx.clearRect(0, 0, innerWidth, innerHeight);

    circleArr.forEach(circle => circle.update());
}

init();
animate();

//examples
//*******************************************************************************
//ctx.fillStyle = 'rgba(255, 0, 0, 0.5)';
//ctx.fillRect(50, 100, 200, 200);
//ctx.fillStyle = 'rgba(0, 255, 0, 0.5)';
//ctx.fillRect(600, 75, 200, 200);
//ctx.fillStyle = 'rgba(255, 255, 0, 0.5)';
//ctx.fillRect(450, 400, 200, 200);
//
////lines
//ctx.beginPath();
//ctx.moveTo(30, 350);
//ctx.lineTo(650, 50);
//ctx.lineTo(750, 650);
//ctx.strokeStyle = 'rgba(200, 50, 255, 1)';
//ctx.stroke();

//arc/circle
/*ctx.beginPath();
ctx.arc(450, 400, 50, 0, Math.PI * 2, false);
ctx.strokeStyle = 'brown';
ctx.stroke();*/

/*for (let i = 0; i < 100; i++) {
    let x = Math.random() * window.innerWidth;
    let y = Math.random() * window.innerHeight;
    let r = Math.random() * 255;
    let g = Math.random() * 255;
    let b = Math.random() * 255;
    
    ctx.beginPath();
    ctx.arc(x, y, 50, 0, Math.PI * 2, false);
    ctx.strokeStyle = 'rgb(' + r + ',' + g + ',' + b + ')';
    ctx.stroke();
}*/