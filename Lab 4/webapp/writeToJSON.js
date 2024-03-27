let Screw = {
    name: "",
    material: "",
    head: "",
    height: "",
    amount: 0
}
function getData(){
    Screw.name = document.getElementById("name").value;
    Screw.material = document.getElementById("material").value;
    Screw.head = document.getElementById("head").value;
    Screw.height = document.getElementById("height").value;
    Screw.amount = document.getElementById("amount").value;
    let screwsJson = JSON.stringify(Screw);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "write", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(screwsJson);
}